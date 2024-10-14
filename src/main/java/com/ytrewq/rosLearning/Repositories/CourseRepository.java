package com.ytrewq.rosLearning.Repositories;

import com.ytrewq.rosLearning.Entities.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends CrudRepository<Course, Integer> {
    Course getCourseByTitle(String title);

    @Query("Select us.courses FROM User us WHERE us.id = :user_id")
    Course[] getAllUserCourses(@Param("user_id") int user_id);
}
