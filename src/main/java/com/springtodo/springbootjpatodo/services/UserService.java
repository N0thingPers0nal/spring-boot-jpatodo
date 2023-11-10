package com.springtodo.springbootjpatodo.services;

import com.springtodo.springbootjpatodo.models.AppUser;
import com.springtodo.springbootjpatodo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public AppUser login(AppUser user) {
       return userRepository.findUserByNameAndPassword(user.getUserName(), user.getPassword());
    }

    public AppUser register(AppUser user) {
        return userRepository.save(user);

    }
}
