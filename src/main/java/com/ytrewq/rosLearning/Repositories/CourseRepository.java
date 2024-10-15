package com.ytrewq.rosLearning.Repositories;


import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Entities.Theme;
import com.ytrewq.rosLearning.Entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CourseRepository extends CrudRepository<Course, Integer> {
    Course getCourseByTitle(String title);

    Set<Course> getAllUserCourses(int user_id);

    <S extends Course> S save (S entity);

}
