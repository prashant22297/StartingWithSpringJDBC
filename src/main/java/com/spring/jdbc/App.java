package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDaoImp;
import com.spring.jdbc.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {
    public static void main(String[] args) {
        System.out.println("My Program Started.");
//        Spring jdbc
//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

        StudentDaoImp studentDao = context.getBean("studentdaoimp",StudentDaoImp.class);
        Student student = new Student();
//        Insert a student
//        student.setId(666);
//        student.setName("John");
//        student.setCity("Lucknow");
//        int r = studentDao.insert(student);
//        System.out.println("Student Added:"+ r);

//        update a row
//        student.setId(3);
//        student.setName("Priya");
//        student.setCity("Mau");
//        int rr= studentDao.update(student);
//        System.out.println("Student Updated:"+ rr);

//        Delete a row
//        student.setId(666);
//        int rrr= studentDao.delete(student);
//        System.out.println("Student Deleted:" + rrr);

//        fecting a single row
//        System.out.println(studentDao.getStudent(555));

//        fetching all row
        System.out.println(studentDao.getAllStudent());
    }
}