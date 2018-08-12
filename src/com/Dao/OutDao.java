package com.Dao;

import com.com.bean.Order;
import com.com.bean.Out;
import com.db.DB;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OutDao {
    private static Connection connection = null;

    static {
        connection = DB.getConnection();
    }

    /**
     * 根据处理状态获得相应的out表集合
     * @param flagName
     * @param flag
     * @return
     */
    public List<Out> getOut(String flagName,Boolean flag){
        List<Out> list = new ArrayList<>();

        ResultSet resultSet = null;

        resultSet = new SelectDao().getSelectResultSet(String.valueOf(flag),"out",flagName);

        try {
            while (resultSet.next()){
                Out out = new Out();

                out.setoID(resultSet.getInt(1));
                out.setoCode(resultSet.getString(2));
                out.setgID(resultSet.getInt(3));
                out.setuID(resultSet.getInt(5));
                out.setOutDate(resultSet.getDate(6));
                out.setOutManager(resultSet.getString(7));
                out.setoWay(resultSet.getString(8));
                out.setoCount(resultSet.getInt(9));
                out.setVerif(resultSet.getBoolean(10));
                out.setPass(resultSet.getBoolean(11));
                out.setDeal(resultSet.getBoolean(12));
                list.add(out);
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

    /**
     * 通过订单设置出库单
     * @param order
     * @return
     */
    public Boolean setOut(Order order){
        Boolean b = false;
        PreparedStatement preparedStatement = null;
        String sql = "insert into o_ut(o_id,o_code,g_id,u_id,out_date,out_manager,o_way,o_count,isVerfy,isPass,isDeal)" +
                " values (?,?,?,?,?,?,?,?,?,?,?)";
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmssZ");

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,Integer.valueOf(format.format(date)));
            preparedStatement.setString(2,format.format(date));
            preparedStatement.setInt(3,order.getgID());
            preparedStatement.setInt(4,order.getuID());
            preparedStatement.setDate(5,new java.sql.Date(System.currentTimeMillis()));
            preparedStatement.setString(6,"管理员");
            preparedStatement.setString(7,"默认");
            preparedStatement.setInt(8,order.getOrCount());
            preparedStatement.setBoolean(9,true);
            preparedStatement.setBoolean(10,false);
            preparedStatement.setBoolean(11,true);
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
