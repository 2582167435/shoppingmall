package com.Dao;

import com.com.bean.User;
import com.com.bean.UserInfo;
import com.db.DB;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDao {

    private static Connection connection = null;

    static {
        connection = DB.getConnection();
    }

    /**
     * 从数据库获取信息
     * @param uName 姓名
     * @param uPassword 密码
     * @return User
     */
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
    public User getUser(String uName){
        String sql = "SELECT * FROM users WHERE u_name='"+uName+"'" ;
        //PreparedStatement preparedStatement = null;
        Statement statement = null;

        ResultSet resultSet = null;
        User user = null;
        try {

            statement = connection.createStatement();

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

    /**
     * 从注册页面获取注册信息
     * @param uName 用户名
     * @param uPassword 用户密码
     * @param uiTelephone 电话
     * @param uiAddress 地址
     * @param uiEmail   电子邮箱
     * @return Boolean
     */
    public boolean Insert(String uName,String uPassword,String uiTelephone,String uiAddress,String uiEmail){
        String sql = "INSERT INTO users(u_id,t_id,u_name,u_password,ui_id)" +
                "VALUE (?,?,?,?,?)";

        PreparedStatement preparedStatement = null;
        java.util.Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("mmss");
        System.out.println(Integer.valueOf(format.format(date)));
        int u_id = Integer.valueOf(format.format(date));

        int t_id = 1;                                       //指定注册类型为用户

        UserInfo userInfo = new UserInfoDao().InserUserInfo(uName,uiTelephone,uiAddress,uiEmail);

        if (!checkExist(uName)) {
            try {
                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setInt(1,u_id);
                preparedStatement.setInt(2,t_id);
                preparedStatement.setString(3,uName);
                preparedStatement.setString(4,uPassword);
                preparedStatement.setInt(5,userInfo.getUiid());

                preparedStatement.executeUpdate();

                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    /**
     * 修改用户密码
     * @param user
     * @param uName
     * @return Boolean
     */

    public boolean updateUser(User user,String uName){
        String sql = "UPDATE  users SET u_password = ?WHERE u_name = ?";
        PreparedStatement preparedStatement = null;
        Boolean flag = false;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getuPassword());
            preparedStatement.setString(2,uName);
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != preparedStatement){
                    preparedStatement.close();}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    /**
     * 检测数据库中是否有该条记录
     * @param uName
     * @return Boolean
     */
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

    /**
     * 检测管理员权限
     * @param uName
     * @return Boolean
     */
    public boolean checkMaster(String uName){
        ;
        boolean flag = false;
        if(new UserTypeDao().getUserType(getUser(uName).gettID()).gettID() == 1){
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }


}
