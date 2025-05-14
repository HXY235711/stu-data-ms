package com.student.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * 查询单个
     * @param sql
     * @return
     */
    //T 代表任意类型
    public static <T> T queryOne(String sql, Class<T> tClass,String ...data) {
        T instance = null;
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);//初步加载SQL

            for(int i=0;i<data.length;i++) {
                pstmt.setString(i + 1, data[i]);
            }
            ResultSet resultSet = pstmt.executeQuery();//将结果结合返回
            //创建一个类的实例
            instance = tClass.getDeclaredConstructor().newInstance();
            Field fields[] = tClass.getDeclaredFields();//获取一个类当中所有声明的字段
            //单个查询
            if(resultSet.next()) {
                for(Field field : fields) {
                    field.setAccessible(true);//允许访问私有字段
                    String res = resultSet.getString(field.getName());//得到了一个结果
                    field.set(instance,res);
                }

            }else{
                return null;
            }

            return instance;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return instance;
    }


    /**
     * 查询所有
     * @param sql
     * @return
     */
    //T 代表任意类型
    public static <T> List<T> queryAll(String sql, Class<T> tClass, String ...data) {
        List<T> list = new ArrayList<>();
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);//初步加载SQL

            for(int i=0;i<data.length;i++) {
                pstmt.setString(i + 1, data[i]);
            }
            System.out.println(pstmt);
            ResultSet resultSet = pstmt.executeQuery();//将结果结合返回
            //单个查询
            while(resultSet.next()) {
                T instance = tClass.getDeclaredConstructor().newInstance();
                Field fields[] = tClass.getDeclaredFields();//获取一个类当中所有声明的字段
                for(Field field : fields) {
                    field.setAccessible(true);//允许访问私有字段
                    String res = resultSet.getString(field.getName());//得到了一个结果
                    field.set(instance,res);
                }
                list.add(instance);
            }

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return list;
    }
}
