package com.study.calcitedemo.utils;

import java.net.URL;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author ruixiang.crx
 * @date 2021/4/14
 */
public class CalciteUtil {
    /**
     *
     * @param filePath
     * @return
     */
    public static Connection getConnect(String filePath) {
        Connection connection = null;
        try {
            URL url = CalciteUtil.class.getResource(filePath);
            String str = URLDecoder.decode(url.toString(), "UTF-8");
            Properties info = new Properties();
            info.put("model", str.replace("file:", ""));
            connection = DriverManager.getConnection("jdbc:calcite:", info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
