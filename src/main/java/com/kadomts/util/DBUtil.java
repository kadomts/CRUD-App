package com.kadomts.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
  private static Connection connection = null;

  public static Connection getConnection(){
      if (connection != null){
          return connection;
      }else {
          try {
              Properties properties = new Properties();
              InputStream inputStream = DBUtil.class.getResourceAsStream("db.properties");
              properties.load(inputStream);
              String driver = properties.getProperty("driver");
              String url = properties.getProperty("url");
              String user = properties.getProperty("user");
              String password = properties.getProperty("password");
              Class.forName(driver);
              connection = DriverManager.getConnection(url, user, password);
          }catch (IOException e){
              e.printStackTrace();
          }catch (ClassNotFoundException e){
              e.printStackTrace();
          }catch (SQLException e){
              e.printStackTrace();
          }
          return connection;
      }
  }
}
