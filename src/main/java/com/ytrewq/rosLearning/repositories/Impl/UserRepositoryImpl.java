package com.ytrewq.rosLearning.repositories.Impl;
import com.ytrewq.rosLearning.entities.User;
import com.ytrewq.rosLearning.repositories.BaseRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserRepositoryImpl extends BaseRepository<User,Integer> {
    public UserRepositoryImpl() {
        super(User.class);
    }
}
