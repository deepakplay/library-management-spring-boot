package org.myproj.libarrymanagementminor.repository;


import org.myproj.libarrymanagementminor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // name
    List<User> findByName(String name);

    List<User> findByNameIn(List<String> name);

    List<User> findByNameContains(String name);

    // email
    List<User> findByEmail(String email);

    List<User> findByEmailIn(List<String> email);

    List<User> findByEmailContains(String email);

    // phone
    List<User> findByPhoneNo(String phone);

    List<User> findByPhoneNoIn(List<String> phone);

    List<User> findByPhoneNoContains(String phone);

}
