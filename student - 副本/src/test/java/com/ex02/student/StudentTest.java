package com.ex02.student;

import com.ex02.student.po.Student;
import com.ex02.student.utils.StudentDBUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentTest {
    SqlSession sqlSession = StudentDBUtil.getSession();

    @Test
    public void findStudentBySno() {
        Student student = sqlSession.selectOne("com.ex02.student.mapper.StudentMapper1.selectStudentBySno", "100000001");
        System.out.println(student);
    }

    @Test
    public void findStudentBySname() {
        List<Student> list = sqlSession.selectList("com.ex02.student.mapper.StudentMapper1.selectStudentBySname", "刘");
        for (Student stu : list) {
            System.out.println(stu);
        }
    }

    @Test
    public void insertStudent() {
        Student student = new Student();
        student.setSno("100000009");
        student.setSname("王强");
        student.setSsex("男");
        student.setSnative("北京");
        student.setMno(1);
        int result = sqlSession.insert("com.ex02.student.mapper.StudentMapper1.insertStudent", student);
        sqlSession.commit();
        System.out.println("成功插入了" + result + "条记录。");
    }

    @Test
    public void deleteStudent() {
        int result = sqlSession.delete("com.ex02.student.mapper.StudentMapper1.deleteStudent", "100000009");
        sqlSession.commit();
        System.out.println("成功删除了" + result + "条记录。");
    }

    @Test
    public void updateStudent() {
        Student student = sqlSession.selectOne("com.ex02.student.mapper.StudentMapper1.selectStudentBySno", "100000001");
        student.setSname("张伟");
        student.setSsex("女");
        student.setSnative("上海");
        int result = sqlSession.update("com.ex02.student.mapper.StudentMapper1.updateStudent", student);
        sqlSession.commit();
        System.out.println("成功更新了" + result + "条记录。");
    }
}
