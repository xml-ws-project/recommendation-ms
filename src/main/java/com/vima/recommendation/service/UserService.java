package com.vima.recommendation.service;

import com.vima.recommendation.model.User;
import com.vima.recommendation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User create(){
        var newUser = User.builder()
                .userId("69")
                .build();

        userRepository.save(newUser);
        return newUser;
    }

    public List<User> findAll(){
        return  userRepository.findAll();
    }
}
