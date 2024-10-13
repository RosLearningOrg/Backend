package com.ytrewq.rosLearning.repositories.Impl;
import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.repositories.BaseRepository;
import org.springframework.stereotype.Repository;
@Repository
public class UserRepositoryImpl extends BaseRepository<User,Integer> {
    public UserRepositoryImpl() {
        super(User.class);
    }
}
