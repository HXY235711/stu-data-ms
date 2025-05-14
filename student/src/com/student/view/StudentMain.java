package com.student.view;

import com.student.utils.DBUntil;

import javax.swing.table.DefaultTableModel;

/**
 * 当前是程序的入口
 */
public class StudentMain {
    public static void main(String[] args) {
        //打开主程序,连接数据ku

        //连接数据库
        DBUntil dbUntil = new DBUntil("root","lyx235711","db_student");
        LoginView loginView = new LoginView();//打开登录窗口

    }


}
