package com.ytrewq.rosLearning.Repositories;

import com.ytrewq.rosLearning.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
