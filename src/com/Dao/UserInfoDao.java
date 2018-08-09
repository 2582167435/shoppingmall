package com.Dao;

import com.com.bean.User;
import com.com.bean.UserInfo;
import com.db.DB;

import java.sql.*;

public class UserInfoDao {
    private static Connection connection = null;

    static {
        connection = DB.getConnection();
    }
    public UserInfo getUserInfo(String uiName){
        String sql = "SELECT * FROM userinfo WHERE ui_name = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        UserInfo userInfo = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,uiName);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                userInfo = new UserInfo();
                userInfo.setUiid(resultSet.getInt(1));
                userInfo.setUiCode(resultSet.getString(2));
                userInfo.setUiName(resultSet.getString(3));
                userInfo.setUiTelephone(resultSet.getString(4));
                userInfo.setUiAddress(resultSet.getString(5));
                userInfo.setUiEmail(resultSet.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(null != resultSet){
                try {
                    resultSet.close();
                    if(null != preparedStatement){
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return userInfo;
    }

    public boolean updateUserInfo(UserInfo userInfo,String uiName){
        boolean b = false;
        String sql = "UPDATE userInfo set ui_telephone = ?,ui_address = ?,ui_email = ? WHERE ui_name = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userInfo.getUiTelephone());
            preparedStatement.setString(2,userInfo.getUiAddress());
            preparedStatement.setString(3,userInfo.getUiEmail());
            preparedStatement.setString(4,uiName);
            preparedStatement.executeUpdate();
            b = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }
}
