package com.Dao;

import com.com.bean.User;
import com.db.DB;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDao {
    private static Connection connection = null;

    static {
        connection = DB.getConnection();
    }

    public User getUser(String uName,String uPassword) {
        String sql = "SELECT * FROM users WHERE u_name='"+uName+"' AND u_password = '"+uPassword+"'";
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

    public boolean register(String uName,String uPassword,String uiTelephone,String uiAddress,String uiEmail){
        String sql = "INSERT INTO users(u_id,t_id,u_name,u_password,ui_id)" +
                "VALUE (?,?,?,?,?)";

        PreparedStatement preparedStatement = null;
        java.util.Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("mmss");
        System.out.println(Integer.valueOf(format.format(date)));
        int u_id = Integer.valueOf(format.format(date));

        int t_id = 1;
        int ui_id = 10002;

        if (!checkExist(uName)) {
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,u_id);
                preparedStatement.setInt(2,t_id);
                preparedStatement.setString(3,uName);
                preparedStatement.setString(4,uPassword);
                preparedStatement.setInt(5,ui_id);
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }




    public boolean checkExist(String uName){
        String sql = "SELECT * FROM USERS WHERE u_name = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setString(1, uName);
             resultSet = preparedStatement.executeQuery();
             while(resultSet.next()){
                 return true;
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

                try {
                    if (null != resultSet) {
                        resultSet.close();
                    }if (null != preparedStatement){
                        preparedStatement.close();}
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }


}
