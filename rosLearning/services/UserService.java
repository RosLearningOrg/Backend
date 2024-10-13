package com.ytrewq.rosLearning.services;

import com.ytrewq.rosLearning.entities.User;
import com.ytrewq.rosLearning.repositories.Impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepositoryImpl userRepository;
    public User getUserById(int user_id){
        return userRepository.findById(User.class,user_id);
    }
}
