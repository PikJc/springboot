package com.cisdi.amqp.utils;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月09日 15:03:00
 */
public interface RabbitConstParam {

    /**
     * exchange
     */
    public final String TOP_EXCHANGE = "TOP-EXCHANGE";
    public final String FANOUT_EXCHANGE = "FANOUT-EXCHANGE";
    public final String DIRECT_EXCHANGE = "DIRECT-EXCHANGE";
    public final String HEADER_ECHANGE = "HEADER-ECHANGE";

    /**
     * rout-key
     */
    public final String ROUT_KEY_A = "ROUT-KEY-A";

    /**
     * query
     */
    public final String QUERY_A = "QUERY-A";
    public final String QUERY_B = "QUERY-B";
}
