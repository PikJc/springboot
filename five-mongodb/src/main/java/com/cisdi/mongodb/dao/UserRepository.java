package com.cisdi.mongodb.dao;

import com.cisdi.mongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月03日 14:18:00
 */
public interface UserRepository extends MongoRepository<User,String> {

    public List<User> findByFirstName(String firstName);

    public User findByLastName(String lastName);
}
