package com.cisdi.mybatis.web;

import com.cisdi.mybatis.dao.CompanyMapper;
import com.cisdi.mybatis.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月03日 09:32:00
 */
@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
     private CompanyMapper companyMapper;

    @GetMapping("/add")
     public Company add(String name){
         Company company = new Company();
         company.setName(name);
         company.setNumber(new Random().nextInt(2019));
         companyMapper.insert(company);
         return company;
     }

     @GetMapping("/find")
     public Company find(String name){
         Company company = companyMapper.findCompany(name);
         return company;
     }

}
