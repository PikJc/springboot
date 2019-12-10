package com.cisdi.first.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月02日 16:22:00
 */
@Data
@Configuration
@PropertySource(value = "classpath:test.properties")
@ConfigurationProperties(prefix = "major")
public class MajorBean {

    private String name;

    private Integer money;

    private String level;
}
