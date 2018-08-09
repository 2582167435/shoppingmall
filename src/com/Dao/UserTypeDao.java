package com.Dao;

import com.com.bean.UserType;
import com.db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTypeDao {

    private static Connection connection = null;

    static {
        connection = DB.getConnection();
    }

    public UserType getUserType(int tid){

        String sql = "SELECT * FROM usertype WHERE t_id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        UserType userType = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,tid);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                userType = new UserType();
                userType.settID(resultSet.getInt(1));
                userType.setUserType(resultSet.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userType;
    }

}
