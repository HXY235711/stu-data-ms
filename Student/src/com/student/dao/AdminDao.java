package com.student.dao;

import com.student.bean.Admin;
import com.student.utils.DBMySQL;

import java.sql.ResultSet;

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
}
