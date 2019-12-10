package com.cisdi.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月03日 13:57:00
 */
@Data
public class User {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private Integer age;
}
