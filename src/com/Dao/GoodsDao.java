package com.Dao;

import com.com.bean.Goods;
import com.db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDao {
    private static Connection connection = null;

    static {
        connection = DB.getConnection();
    }

    /**
     * 获取Goods表的多条数据
     * @param selectString 根据对象名进行
     * @return
     */
    public List<Goods> getGoodList(String selectString){
        List<Goods> list = new ArrayList<>();
        SelectDao selectDao = new SelectDao();
        ResultSet resultSet = null;
        String[] fields = {"g_name","g_type"};

        try {
            for (String field: fields) {
                resultSet = selectDao.getSelectResultSet(selectString,"goods",field);
                if (resultSet.next()){
                    do {
                        Goods goods = new Goods();
                        goods.setgID(resultSet.getInt(1));
                        goods.setgCode(resultSet.getString(2));
                        goods.setgName(resultSet.getString(3));
                        goods.setgCount(resultSet.getInt(4));
                        goods.setgPrice(resultSet.getFloat(5));
                        goods.setgAddress(resultSet.getString(6));
                        goods.setgType(resultSet.getString(7));
                        list.add(goods);
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

    /**
     *      搜索结果
     * @param selectString
     * @return
     */
    public List<Goods> getGood(String selectString){
        String sql = "SELECT * FROM goods WHERE g_name = ? OR g_type = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Goods> goodsList = new ArrayList<Goods>();

        try {

            statement = connection.prepareStatement(sql);

            statement.setString(1,selectString);
            statement.setString(2,selectString);

            resultSet = statement.executeQuery();

            while (resultSet.next()){
                Goods good = new Goods();
                good.setgID(resultSet.getInt("g_id"));
                good.setgCode(resultSet.getString("g_code"));
                good.setgName(resultSet.getString("g_name"));
                good.setgCount(resultSet.getInt("g_count"));
                good.setgPrice(resultSet.getFloat("g_price"));
                good.setgAddress(resultSet.getString("g_address"));
                good.setgType(resultSet.getString("g_type"));

                goodsList.add(good);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goodsList;
    }
}
