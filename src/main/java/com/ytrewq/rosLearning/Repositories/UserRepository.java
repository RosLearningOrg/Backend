package com.ytrewq.rosLearning.Repositories;

import com.ytrewq.rosLearning.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepo<User> {
    Optional<User> findByUsername(String username);
    @Query("SELECT user.coursesIdsStr FROM User user WHERE user.id = %:userId%")
    String findCoursesIdsStrById(@Param("userId")Integer userId);
}
