package com.cisdi.mybatis.dao;

import com.cisdi.mybatis.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月03日 09:21:00
 */
@Mapper
public interface CompanyMapper extends tk.mybatis.mapper.common.Mapper<Company> {

    @Select("select id,name as name,number as number from company where name=#{name}")
    Company findCompany(String name);
}
