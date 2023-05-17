package com.spring.jdbc.dao;

import com.mysql.cj.result.Row;
import com.spring.jdbc.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentdaoimp")
public class StudentDaoImp implements StudentDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insert(Student student) {
        String query = "insert into student(id,name,city) values(?,?,?);";
        int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return r;
    }

    @Override
    public int update(Student student) {
        String query = "update student set name=?, city=? where id=?";
        int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
        return r;
    }

    @Override
    public int delete(Student student) {
        String query = "delete from student where id=?";
        int r = this.jdbcTemplate.update(query,student.getId());
        return r;
    }

//    Selecting single student data
    @Override
    public Student getStudent(int studentId) {
        String query = "select * from student where id=?;";
        RowMapperImp rowMapper = new RowMapperImp();
        Student s = this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
        return s;
    }

//    Selecting all student
    @Override
    public List<Student> getAllStudent() {
        String query = "select * from student;";
        RowMapperImp rowMapper = new RowMapperImp();
        List<Student> s = this.jdbcTemplate.query(query,rowMapper);
        return s;
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
