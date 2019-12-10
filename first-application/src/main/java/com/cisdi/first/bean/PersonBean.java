package com.cisdi.first.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月02日 16:36:00
 */
@Data
@Component
public class PersonBean {

    @Value("${person.name}")
    private String name;

    @Value("${person.age}")
    private Integer age;

    @Value("${person.sex}")
    private String sex;
}
