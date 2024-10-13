package com.ytrewq.rosLearning.Repositories;


import com.ytrewq.rosLearning.Entities.Course;

import java.util.Set;

public interface CourseRepository {
    Course getCourseByTitle(String title);

    Set<Course> getAllUserCourses(int user_id);

}
