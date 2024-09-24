package com.ytrewq.rosLearning.repositories;

import com.ytrewq.rosLearning.entities.Course;
import com.ytrewq.rosLearning.entities.Lesson;
import com.ytrewq.rosLearning.entities.Task;
import com.ytrewq.rosLearning.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    List<Course> getAllUserCourses(int user_id);
    List<Task> getAllUserTasksResult(int user_id);

}
