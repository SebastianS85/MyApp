package com.checklist.demo.repository;

import com.checklist.demo.domain.user.User;
import com.checklist.demo.domain.user.UserDto;

import java.util.List;


public interface UserService {

    User save(UserDto user);

    List<User> findAll();

    void delete(long id);

    User findOne(String username);

    User findById(Long id);
}
