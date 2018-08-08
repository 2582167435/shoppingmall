package com.Dao;

import com.com.bean.User;
import com.db.DB;

import java.sql.*;

public class UserDao {
    private static Connection connection = null;

    static {
        connection = DB.getConnection();
    }

    public User getUser(String uName) {
        String sql = "SELECT * FROM users WHERE u_name='"+uName+"'";
       //PreparedStatement preparedStatement = null;
        Statement statement = null;

        ResultSet resultSet = null;
        User user = null;
        try {
            //preparedStatement = connection.prepareStatement(sql);
            statement = connection.createStatement();

           // preparedStatement.setString(1, uName);
           // resultSet = preparedStatement.executeQuery();

            resultSet = statement.executeQuery(sql);


            while(resultSet.next()){
                user = new User();
                user.setuID(resultSet.getInt(1));
                user.settID(resultSet.getInt(2));
                user.setuName(resultSet.getString(3));
                user.setuPassword(resultSet.getString(4));
                user.setUiID(resultSet.getInt(5));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != resultSet) {
                try {
                    resultSet.close();
                    if (null != statement) {
                        statement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }
}
