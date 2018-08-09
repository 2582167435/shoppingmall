package com.Dao;

import com.com.bean.Entry;
import com.db.DB;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntryDao {
    private static Connection connection = null;
    static {
        connection  = DB.getConnection();
    }

    /**
     * 像entry表中插入一条数据
     * @param entry 插入的entry对象
     * @return true or false
     */
    public  boolean insertEntry(Entry entry){
        PreparedStatement preparedStatement = null;
        Boolean b = false;
        String sql = "INSERT INTO entry(e_id,g_id,s_id,entry_manager,entry_date,e_count,e_way,isVerify,isPass,isDeal)"+
                "VALUE(?,?,?,?,?,?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,entry.geteID());
            preparedStatement.setInt(2,entry.getgID());
            preparedStatement.setInt(3,entry.getsID());
            preparedStatement.setString(4,entry.getEntryManager());
            preparedStatement.setDate(5,entry.getEntryDate());
            preparedStatement.setInt(6,entry.geteCount());
            preparedStatement.setString(7,entry.geteWay());
            preparedStatement.setBoolean(8,entry.isVerify());
            preparedStatement.setBoolean(9,entry.isPass());
            preparedStatement.setBoolean(10,entry.isDeal());
            preparedStatement.executeUpdate();
            b = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (null != preparedStatement){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return b;
    }
}
