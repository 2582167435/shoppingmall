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
}
