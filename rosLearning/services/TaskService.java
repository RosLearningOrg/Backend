package com.ytrewq.rosLearning.services;

import com.ytrewq.rosLearning.entities.Course;
import com.ytrewq.rosLearning.entities.Task;
import com.ytrewq.rosLearning.entities.User;
import com.ytrewq.rosLearning.repositories.Impl.CourseRepositoryImpl;
import com.ytrewq.rosLearning.repositories.Impl.TaskRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TaskService {
    @Autowired
    TaskRepositoryImpl taskRepository;
    @Autowired
    CourseRepositoryImpl courseRepository;
    public Set<Task> getAllCourseTasks(int course_id) {
        Course  course=courseRepository.findById(Course.class,course_id);
        return taskRepository.getAllCourseTasks(course);
    }
    public Task getTaskById(int id){
        return taskRepository.findById(Task.class,id);
    }
}
