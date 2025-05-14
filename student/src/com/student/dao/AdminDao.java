package com.student.dao;

import com.student.bean.Admin;
import com.student.utils.DBMySQL;
import com.student.utils.DBUntil;

import java.sql.ResultSet;
import java.util.List;

public class AdminDao {
        /**
         * 是否登录
         * @param account
         * @param password
         * @return
         */
        public static Admin isLogin(String username,String password) {
                String sql = "select * from s_admin where account=? and pwd=?";
                ResultSet res = DBMySQL.query(sql, username, password);//获取到一个结果集合
                try {
                        if(res.next()){
                                Admin admin = new Admin( res.getString("account"),
                                        res.getString("pwd"),
                                        res.getString("xm"),
                                        res.getString("sta"),
                                        res.getString("pow"));
                                return admin;

                        }
                }catch (Exception e) {

                }
                return null;
        }

        /**
         * 实现注册账号
         * @param username
         * @param password
         * @param xm
         * @param sta
         * @param pow
         * @return
         */
        public static int register(String account,String pwd,String xm,String sta,String pow) {
                String sql = "insert into s_admin values(?,?,?,?,?)";
                int result = DBMySQL.update(sql, account, pwd, xm, sta, pow);
                return result;
        }


        /**
         * 实现更新账号是否在线的状态
         * @param account
         * @param sta
         * @return
         */
        public static int update(String account,String sta) {
                String sql = "update s_admin set sta=? where account=?";
                return DBMySQL.update(sql, sta, account);
        }


        /**
         * 通过UUID进行修改
         * @param uuid
         * @param sta
         * @return
         */
        public static int updateByUuid(String uuid,String sta) {
                String sql = "update s_admin set sta=? where sta=?";
                return DBMySQL.update(sql, sta, uuid);
        }


        /**
         * 查询所有在线账号
         * @return
         */
        public static List<Admin> showAccount() {
                String sql = "select * from s_admin where sta!='0'";
                List<Admin> list= DBMySQL.queryAll(sql,Admin.class);//获取到一个结果集合
                return list;
        }


        /**
         * 查询所有账号
         * @return
         */
        public static List<Admin> showAllAccount() {
                String sql = "select * from s_admin";
                List<Admin> list= DBMySQL.queryAll(sql,Admin.class);//获取到一个结果集合
                return list;
        }

        /**
         * 查询指定账号
         * @return
         */
        public static Admin showAccount(String uuid) {
                String sql = "select * from s_admin where sta=?";
                Admin list= DBMySQL.queryOne(sql,Admin.class,uuid);//获取到一个结果集合
                return list;
        }

}
