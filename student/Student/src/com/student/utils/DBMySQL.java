package com.student.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 封装查询和更改的方式
 */
public class DBMySQL {

    private static Connection con = DBUntil.con;
    /**
     * 实现查询,封装一个查询工具
     * @param sql
     * @return
     */
    public static ResultSet query(String sql,String ...data) {
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);//初步加载SQL

            for(int i=0;i<data.length;i++) {
                pstmt.setString(i + 1, data[i]);
            }
            ResultSet resultSet = pstmt.executeQuery();//将结果结合返回
            return resultSet;

        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * -1代表报错 0代表更改失败 大于一代表成功
     * @param sql
     * @param data
     * @return
     */
    public static int update(String sql,String ...data) {
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);//初步加载SQL

            for(int i=0;i<data.length;i++) {
                pstmt.setString(i + 1, data[i]);
            }
            return pstmt.executeUpdate();//将结果结合返回

        } catch (SQLException e) {
            return -1;
        }
    }
}
