package com.ytrewq.rosLearning.repositories;

import com.ytrewq.rosLearning.entities.Course;
import com.ytrewq.rosLearning.entities.Lesson;
import com.ytrewq.rosLearning.entities.Task;
import com.ytrewq.rosLearning.entities.User;
import org.springframework.stereotype.Repository;

@Repository

public interface AdminRepository {
    Task createTask(Task task);
    Course createCourse(Course course);
    Lesson createLesson(Lesson lesson);


}
