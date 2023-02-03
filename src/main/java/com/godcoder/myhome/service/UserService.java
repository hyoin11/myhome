package com.godcoder.myhome.service;

import com.godcoder.myhome.Repository.UserRepository;
import com.godcoder.myhome.model.Role;
import com.godcoder.myhome.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user){
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        user.setEnabled(true);
        Role role = new Role();
        role.setId(1L);
        user.getRoles().add(role);
        if(user.getUsername().equals("admin")){
            Role admin_role = new Role();
            admin_role.setId(2L);
            user.getRoles().add(admin_role);
        }
        return userRepository.save(user);
    }
}
