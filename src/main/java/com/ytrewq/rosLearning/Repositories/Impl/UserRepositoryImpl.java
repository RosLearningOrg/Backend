package com.ytrewq.rosLearning.Repositories.Impl;

import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.Repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends BaseRepository<User, Integer> {
    public UserRepositoryImpl() {
        super(User.class);
    }
}
