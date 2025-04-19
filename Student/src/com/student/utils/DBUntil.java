package com.student.utils;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 功能：负责创建数据库连接
 */
public class DBUntil {

    private String account;
    private String password;
    private String db;
    /**
     * 数据库账号与密码和数据库名称
     * @param account
     * @param password
     */
    public DBUntil(String account , String password,String db) {
        this.account = account;
        this.password = password;
        this.db = db;
        //实现加载数据库的驱动，以及创建数据库的连接
        init();
    }

    public static Connection con = null;

    private void init(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("加载驱动成功");
        }catch (Exception e){
            System.out.println("加载驱动失败");
        }

        //连接数据库
        try{
            String url = "jdbc:mysql://localhost:3306/"+ db+"?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";
            con = DriverManager.getConnection(url,account,password);
            System.out.println("连接数据库成功");
        }catch (Exception e){
            System.out.println("连接数据库失败");
            String temp = e.getMessage();
            System.out.println(temp);
            String[] arr1 = temp.split("");
            if(arr1[0].equals("Unknown")){
                System.out.println("请建立名字为："+arr1[2]+"数据库");
            }
            if(arr1[0].equals("Access")){
                System.out.println("密码错误");
            }
        }
    }
}
