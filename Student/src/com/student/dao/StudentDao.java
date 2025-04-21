package com.student.dao;

import com.student.bean.Student;
import com.student.utils.DBMySQL;

public class StudentDao {


    public int addStudent(Student student) {
        String sql = "insert into s_student (number,xm,sex,age,grade)values(?,?,?,?,?)";
     int res=  DBMySQL.update(sql,
             student.getNumber(),
                student.getXm(),
                student.getSex(),
                student.getAge(),
                student.getGrade());
     return res;
    }
}
