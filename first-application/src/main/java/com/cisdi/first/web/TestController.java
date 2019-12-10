package com.cisdi.first.web;

import com.cisdi.first.bean.MajorBean;
import com.cisdi.first.bean.Person;
import com.cisdi.first.bean.PersonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月02日 16:18:00
 */
@RestController
public class TestController {

    @Autowired
    PersonBean person;
    @Autowired
    MajorBean majorBean;

    @GetMapping("/person")
    public String printPerson(){
        return person.toString();
    }


    @GetMapping("/major")
    public String printMajor(){
        return majorBean.toString();
    }
}
