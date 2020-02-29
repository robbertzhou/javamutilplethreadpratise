package com.zy.other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * create 2020-02-28
 * author zhouyu
 * desc 测试Mycat集群
 */
public class MycatTest {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        Connection connection = getConnection();
        connection.setAutoCommit(true);
        PreparedStatement ps = connection.prepareStatement("insert into student values(?, ?)");
        for (int i=6;i<100000;i++){
            ps.setInt(1,i);
            ps.setString(2,"jjj");
            ps.execute();
        }
        connection.commit();




    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://192.168.0.113:8066/TESTDB?characterEncoding=utf-8","user","user");
    }
}
