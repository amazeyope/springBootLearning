package com.yope.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author yope
 * @version 1.0.0
 * @date 16/08/27 02:34.
 * @github https://github.com/amazeyope
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    User findByName(String name);

    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);

    User findByNameAndAge(String name, Integer age);

    User save(User User);

    User findById(Long id);

    void delete(Long id);


}
