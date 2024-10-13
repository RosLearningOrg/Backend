package com.ytrewq.rosLearning.services;

import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.repositories.Impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepositoryImpl userRepository;
    public User getUserById(int user_id){
        return userRepository.findById(User.class,user_id);
    }
}
