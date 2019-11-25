package com.checklist.demo.repository;

import com.checklist.demo.domain.user.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RoleRepository extends CrudRepository<Role,Long> {


    Set<Role> findByName(String name);
}
