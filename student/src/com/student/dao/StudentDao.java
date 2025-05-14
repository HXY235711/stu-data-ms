package com.student.dao;

import com.student.bean.Student;
import com.student.utils.DBMySQL;
import com.student.utils.DBUntil;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.List;

public class StudentDao {

    /**
     * 添加学生
     * @param student
     * @return
     */
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


    public int delStudent(String id) {
        String sql = "DELETE FROM s_student  where number=?";
        int res=  DBMySQL.update(sql,id);
        return res;
    }
    /**
     * 实现更改学生
     * @param student
     * @return
     */
    public int updateStudent(Student student,String num) {
        String sql = "update s_student set number=?,xm=?,sex=?,age=?,grade=? where number=?";
        int res=  DBMySQL.update(sql,
                student.getNumber(),
                student.getXm(),
                student.getSex(),
                student.getAge(),
                student.getGrade(),num);
        return res;
    }

    /**
     * 通过学号查询
     * @param id
     * @return
     */
    public Student getStudentByNumber(String id) {
        String sql = "select * from s_student where number=?";
        Student stu= DBMySQL.queryOne(sql,Student.class,id); //返回一个存放学生的javabean
        return stu;

    }

    /**
     * 查询全部学生
     * @return
     */
    public List<Student> getStudentAll() {
        String sql = "select * from s_student";
        List<Student> stu= DBMySQL.queryAll(sql,Student.class); //返回一个存放学生的javabean
        return stu;

    }


    /**
     * 实现条件查找
     * @return
     */
    public List<Student> getStudentWhere(Student student) throws IllegalAccessException {
        String sql = "select * from s_student ";
        Field[] fieldes = student.getClass().getDeclaredFields();//获取到所有的字段名称
        int z=0;
        for(int i=0;i<fieldes.length;i++){
            Field fielde=fieldes[i];
            fielde.setAccessible(true);//允许访问私有字段
            String name=fielde.getName();//字段名称
            String value=fielde.get(student).toString();//获取对应的值


            if(!(value.isEmpty()||value.equals(""))){
                //是没有 sex=? and name=?
                if(z==0){//没有and
                    sql=sql+"where "+name+" like '%"+value+"%' ";
                }else{
                    sql=sql+"and "+name+"like '%"+value+"%' ";
                }
                z++;
            }
        }



        List<Student> stu= DBMySQL.queryAll(sql,Student.class); //返回一个存放学生的javabean
        return stu;

    }
}
