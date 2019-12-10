package com.cisdi.first.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月02日 16:14:00
 */
@Data
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    private String name;

    private Integer age;

    private String sex;
}
