package com.Dao;

import com.com.bean.Goods;
import com.db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectDao {
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    static {
        connection = DB.getConnection();
    }

    /**
     * 根据关键字，表名，字段名获取一个ResultSet对象
     * @param selectString 关键字
     * @param tableName 表名
     * @param fieldName 字段名
     * @return ResultSet
     */
    public ResultSet getSelectResultSet(String selectString,String tableName,String fieldName){
        String sql = "SELECT * FROM " + tableName + " WHERE "+ fieldName + " = ?";
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,selectString);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            preparedStatement = null;
        }
        return resultSet;
    }
}
