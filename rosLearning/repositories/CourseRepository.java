package com.ytrewq.rosLearning.repositories;

import com.ytrewq.rosLearning.entities.Course;
import com.ytrewq.rosLearning.entities.Theme;
import com.ytrewq.rosLearning.entities.User;

import java.util.List;
import java.util.Set;

public interface CourseRepository {
    Course getCourseByTitle(String title);
    Set<Course> getAllUserCourses(User user);
}
