package com.Dao;

import com.com.bean.Entry;
import com.db.DB;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public void alterEntry(Entry entry){
        PreparedStatement preparedStatement = null;
        Boolean b = false;
        String sql = "UPDATE entry SET g_id=? ,s_id=?,entry_manager=?,e_count=?,e_way=? WHERE e_id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,entry.getgID());
            preparedStatement.setInt(2,entry.getsID());
            preparedStatement.setString(3,entry.getEntryManager());
            preparedStatement.setInt(4,entry.geteCount());
            preparedStatement.setString(5,entry.geteWay());
            preparedStatement.setInt(6,entry.geteID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (null != preparedStatement){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {

                }
            }
        }
    }
    public void updateStatusEntry(int eID){
        PreparedStatement preparedStatement = null;
        Boolean b = false;
        String sql = "UPDATE entry SET isVerify=1 , ispass=1,isdeal=1 WHERE e_id = "+eID;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (null != preparedStatement){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {

                }
            }
        }

    }
    /**
     * 获得entry表所有数据的list集合
     * @return list
     */
    public List<Entry> getEntry(){
        List<Entry> list = new ArrayList<>();
        ResultSet resultSet = null;

        resultSet = new SelectDao().getSelectResultSet("Boolean","true","entry","isdeal");

        try {
            while (resultSet.next()){
                Entry entry = new Entry();
                entry.seteID(resultSet.getInt(1));
                entry.setgID(resultSet.getInt(2));
                entry.setsID(resultSet.getInt(3));
                entry.setEntryManager(resultSet.getString(4));
                entry.setEntryDate(resultSet.getDate(5));
                entry.seteCount(resultSet.getInt(6));
                entry.seteWay(resultSet.getString(7));
                entry.setVerify(resultSet.getBoolean(8));
                entry.setPass(resultSet.getBoolean(9));
                entry.setDeal(resultSet.getBoolean(10));
                list.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (null != resultSet){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public List<Entry> getEntrys(String selectName){
        List<Entry> list = new ArrayList<>();
        SelectDao selectDao = new SelectDao();
        ResultSet resultSet = null;
        String[] fields = {"e_id","g_id","s_id"};

        try {
            for (String field: fields) {
                resultSet = selectDao.getSelectResultSet("String",selectName,"entry",field);
                if (resultSet.next()){
                    do {
                        Entry entry = new Entry();
                        entry.seteID(resultSet.getInt(1));
                        entry.setgID(resultSet.getInt(2));
                        entry.setsID(resultSet.getInt(3));
                        entry.setEntryManager(resultSet.getString(4));
                        entry.setEntryDate(resultSet.getDate(5));
                        entry.seteCount(resultSet.getInt(6));
                        entry.seteWay(resultSet.getString(7));
                        entry.setVerify(resultSet.getBoolean(8));
                        entry.setPass(resultSet.getBoolean(9));
                        entry.setDeal(resultSet.getBoolean(10));
                        list.add(entry);
                    }while (resultSet.next());
                    break;


                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(null != resultSet){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
