package com.cisdi.jdbc.web;

import com.cisdi.jdbc.entity.Student;
import com.cisdi.jdbc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月02日 17:21:00
 */
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("add")
    public String addStudent(@RequestParam("name") String name){
        Random random = new Random();
        Student student = new Student();
        student.setName(name);
        student.setAge(random.nextInt(100));
        student.setSex(random.nextInt()%2==0?"男":"女");
        studentService.addStudent(student);
        return "操作成功";
    }

    @GetMapping("all")
    public Object queryAll(){
        return studentService.selectAll();
    }

    @GetMapping("delete/{id}")
    public Object deleteStudent(@PathVariable Integer id){
        studentService.deleteStuden(id);
        return "删除成功";
    }

    @GetMapping("query")
    public Object queryStudent(@RequestParam("name")String name){
        return studentService.selectStudent(name);
    }

}
