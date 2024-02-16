package com.carlos.sbcrud.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.carlos.sbcrud.entities.Role;

public interface RoleRepository extends CrudRepository<Role,Long>{

    Optional<Role> findByName(String name);
}
