package com.cisdi.mybatis.entity;

import lombok.Data;
import org.hibernate.annotations.Table;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月03日 09:17:00
 */
@Data
@Entity
public class Company {

    @Id
    @GeneratedValue(generator = "JDBC")
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private String name;

    private Integer number;
}
