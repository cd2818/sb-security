package com.carlos.sbcrud.servicies;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carlos.sbcrud.entities.Role;
import com.carlos.sbcrud.entities.User;
import com.carlos.sbcrud.repositories.RoleRepository;
import com.carlos.sbcrud.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return (List<User>)repository.findAll();
    }


    @Override
    @Transactional
    public User save(User user) {
        String claveEncoded = passwordEncoder.encode(user.getClave());
        Optional<Role> optionalRoleUser = roleRepository.findByName("ROLE_USER");

        List<Role> roles = new ArrayList<>();

        optionalRoleUser.ifPresent(
            role -> roles.add(role)
        );
        if(user.isAdmin()){
            Optional<Role> optionalRoleAdmin = roleRepository.findByName("ROLE_ADMIN");
            optionalRoleAdmin.ifPresent(
                role -> roles.add(role)
            );
        }

        user.setRoles(roles);
        user.setClave(claveEncoded);

        return repository.save(user);
    }
}
