package com.hackathon.temasek.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hackathon.temasek.entity.UserEntity;
import com.hackathon.temasek.model.User;
import com.hackathon.temasek.repository.UserRepository;



@Service
public class TemasekUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepository;
 
    @Override
    public UserDetails loadUserByUsername(String username) {
    	System.out.print("USername ::::::::::::"+username);
        UserEntity userEntity = userRepository.findOne(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }
        User user = new User();
        user.setName(userEntity.getName());
        user.setPassword(userEntity.getPassword());
        System.out.print("PAssword ::::::::::::"+userEntity.getPassword());
        user.setUserId(userEntity.getUserId());
        List<String> userRoles=Arrays.asList("ADMIN");
        return new TemasekUserDetails(user, userRoles);
    }
}
