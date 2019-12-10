package com.cisdi.amqp.utils;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月09日 15:14:00
 */
@Data
@Accessors(chain = true)
public class Message {

    private String name;

    private String content;
}
