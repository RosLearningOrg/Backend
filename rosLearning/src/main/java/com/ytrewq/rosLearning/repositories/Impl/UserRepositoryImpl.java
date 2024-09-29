package com.ytrewq.rosLearning.repositories.Impl;

import com.ytrewq.rosLearning.entities.Course;
import com.ytrewq.rosLearning.entities.Task;
import com.ytrewq.rosLearning.entities.User;
import com.ytrewq.rosLearning.repositories.BaseRepository;
import com.ytrewq.rosLearning.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepositoryImpl extends BaseRepository<User,Long> implements UserRepository {
    @Autowired
    EntityManager entityManager;
    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public List<Course> getAllUserCourses(int user_id) {
        return null;
    }

    @Override
    public List<Task> getAllUserTasksResult(int user_id) {
        return null;
    }
}
