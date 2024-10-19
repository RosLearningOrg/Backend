package com.ytrewq.rosLearning.Repositories;

import com.ytrewq.rosLearning.Entities.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepo<User> {
}
