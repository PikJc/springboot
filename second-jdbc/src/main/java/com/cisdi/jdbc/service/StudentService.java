package com.cisdi.jdbc.service;

import com.cisdi.jdbc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月02日 17:13:00
 */
@Service
public class StudentService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addStudent(Student student){
        jdbcTemplate.update("insert into student(name,age,sex) value (?,?,?)",student.getName(),student.getAge(),student.getSex());
    }

    public void deleteStuden(Integer id){
        jdbcTemplate.update("delete from student where id = ?",id);
    }

    public List<Student> selectStudent(String name){
        List<Student> students = jdbcTemplate.query("select * from student s where s.name like '%"+name+"%'",new Object[]{},new BeanPropertyRowMapper(Student.class));
        return students;
    }

    public void deleteAllStudents() {
        jdbcTemplate.update("delete from student");
    }

    public List<Map<String, Object>> selectAll(){
        return jdbcTemplate.queryForList("select id,name,age,sex from student");
    }
}
