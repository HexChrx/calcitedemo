package com.study.calcitedemo;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.study.calcitedemo.utils.CalciteUtil;

import java.sql.*;
import java.util.List;
import java.util.Map;


public class CalciteDemo {
    public static void main(String[] args) throws SQLException {
        String modelFile = "/model.json";

        Connection connection = CalciteUtil.getConnect(modelFile);
        Statement statement = connection.createStatement();
        //String sql = "select userinfo.id as uid, userinfo.name1 as name, dep.NAME as dept_name, mem1.id as mid, mem1.sub as msub, mem1.score as mscore from test_csv.\"userinfo\" as userinfo left join test_mem.\"MEM_TABLE_1\" as mem1 on userinfo.id = mem1.id left join test_mysql.\"depts\" as dep on dep.user_id = userinfo.id";
        String sql = "select dep.name as deptname, mem1.sub, avg(mem1.score) as avgscore from test_csv.\"userinfo\" as userinfo left join test_mem.\"MEM_TABLE_1\" as mem1 on userinfo.id = mem1.id left join test_mysql.\"depts\" as dep on dep.user_id = userinfo.id group by dep.name, mem1.sub";
        System.out.println(JSON.toJSONString(query(sql, statement)));
    }

    private static List<Map<String, Object>> query(String sql, Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery(sql);
        return getData(resultSet);
    }

    private static List<Map<String, Object>> getData(ResultSet resultSet) throws SQLException {
        List<Map<String, Object>> list = Lists.newArrayList();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnSize = metaData.getColumnCount();

        while (resultSet.next()) {
            Map<String, Object> item = Maps.newHashMap();
            for (int i = 1; i <= columnSize; i++) {
                item.put(metaData.getColumnName(i), resultSet.getObject(i));
            }
            list.add(item);
        }
        return list;
    }
}
