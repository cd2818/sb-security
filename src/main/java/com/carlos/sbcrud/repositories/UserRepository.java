package com.carlos.sbcrud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.carlos.sbcrud.entities.User;

public interface UserRepository extends CrudRepository<User,Long> {

}
