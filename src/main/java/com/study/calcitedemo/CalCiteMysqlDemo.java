package com.study.calcitedemo;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.study.calcitedemo.utils.CalciteUtil;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Map;


public class CalCiteMysqlDemo {
    public static void main(String[] args) throws IOException, SQLException {

        String modelFile = "/model.json";

        Connection connection = CalciteUtil.getConnect(modelFile);

        Statement statement = connection.createStatement();
        test1(statement);
    }

    private static void test1(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from \"TEST_MYSQL\".\"depts\"");
        System.out.println(JSON.toJSONString(getData(resultSet)));
    }

    private static List<Map<String, Object>> getData(ResultSet resultSet) throws SQLException {
        List<Map<String, Object>> list = Lists.newLinkedList();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnSize = metaData.getColumnCount();

        while (resultSet.next()) {
            Map<String, Object> map = Maps.newHashMap();
            for (int i = 1; i <= columnSize; i++) {
                map.put(metaData.getColumnName(i), resultSet.getObject(i));
            }
            list.add(map);
        }
        return list;
    }
}
