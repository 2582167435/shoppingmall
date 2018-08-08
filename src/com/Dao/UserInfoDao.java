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
                userInfo.setUiTelephone(resultSet.getString(3));
                userInfo.setUiAddress(resultSet.getString(4));
                userInfo.setUiEmail(resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (null != resultSet) {
                try {
                    resultSet.close();
                    if (null != preparedStatement) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return userInfo;
        }


    }
}
