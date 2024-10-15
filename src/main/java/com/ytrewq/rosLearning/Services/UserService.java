package com.ytrewq.rosLearning.Services;

import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public Optional<User> getUserById(int user_id){
        return userRepository.findById(user_id);
    }
}
