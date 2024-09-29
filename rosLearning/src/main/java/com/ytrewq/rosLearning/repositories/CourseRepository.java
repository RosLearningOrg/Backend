package com.ytrewq.rosLearning.repositories;

import com.ytrewq.rosLearning.entities.Course;

import java.util.List;

public interface CourseRepository {
    Course getCourseByName(String name);
}
