package com.ex02.student.mapper;

import com.ex02.student.po.Student;
import com.ex02.student.utils.StudentDBUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentMapper1Test {
    private SqlSession sqlSession;
    private StudentMapper1 studentMapper;

    @Before
    public void setUp() {
        sqlSession = StudentDBUtil.getSession();
        studentMapper = sqlSession.getMapper(StudentMapper1.class);
    }

    @After
    public void tearDown() {
        sqlSession.commit();
        sqlSession.close();
    }

    // 查询学生信息
    @Test
    public void testSelectStudentBySno() {
        Student student = studentMapper.selectStudentBySno("100000001");
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("未找到学号为 100000001 的学生");
        }
    }

    // 模糊查询学生信息
    @Test
    public void testSelectStudentBySname() {
        List<Student> students = studentMapper.selectStudentBySname("刘");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // 插入新学生
    @Test
    public void testInsertStudent() {
        Student student = new Student();
        student.setSno("100000010");
        student.setSname("张三");
        student.setSsex("男");
        student.setSnative("北京");
        student.setMno(1);
        int result = studentMapper.insertStudent(student);
        System.out.println("插入了 " + result + " 条记录。");
    }

    // 更新学生信息
    @Test
    public void testUpdateStudent() {
        Student student = studentMapper.selectStudentBySno("100000001");

        if (student != null) {
            student.setSname("张伟");
            student.setSsex("女");
            student.setSnative("上海");
            int result = studentMapper.updateStudent(student);
            System.out.println("更新了 " + result + " 条记录。");
        } else {
            System.out.println("未找到学号为 100000001 的学生，无法更新。");
        }
    }

    // 删除学生信息
    @Test
    public void testDeleteStudent() {
        int result = studentMapper.deleteStudent("100000010");
        System.out.println("删除了 " + result + " 条记录。");
    }
}
