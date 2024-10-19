package com.ytrewq.rosLearning.Repositories;

import com.ytrewq.rosLearning.Entities.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends BaseRepo<Course> {
    Course getCourseByTitle(String title);

//    @Query("Select user.courses FROM User user WHERE user = :user AND ")
//    Course[] getAllUserCourses(@Param("user_id") int user_id);
}
