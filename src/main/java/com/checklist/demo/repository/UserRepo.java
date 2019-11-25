package com.checklist.demo.repository;

import com.checklist.demo.domain.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Long> {

}
