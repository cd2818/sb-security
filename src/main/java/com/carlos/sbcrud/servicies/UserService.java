package com.carlos.sbcrud.servicies;

import java.util.List;

import com.carlos.sbcrud.entities.User;

public interface UserService {

    List<User> findAll();

    User save(User user);
}
