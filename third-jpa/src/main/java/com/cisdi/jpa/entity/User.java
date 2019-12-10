package com.cisdi.jpa.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月03日 08:37:00
 */
@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer age;

    private String sex;
}
