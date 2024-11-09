package com.ytrewq.rosLearning.Repositories;

import com.ytrewq.rosLearning.Entities.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends BaseRepo<Course> {
    boolean existsById(int courseId);
}
