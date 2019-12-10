package com.cisdi.jpa.dao;

import com.cisdi.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月03日 08:39:00
 */
@Repository
public interface UserDao extends JpaRepository<User,Integer> {
}
