package com.ytrewq.rosLearning.services;

import com.ytrewq.rosLearning.dto.CourseDto;
import com.ytrewq.rosLearning.dto.TaskDto;
import com.ytrewq.rosLearning.entities.Course;
import com.ytrewq.rosLearning.entities.Task;
import com.ytrewq.rosLearning.entities.User;
import com.ytrewq.rosLearning.repositories.Impl.CourseRepositoryImpl;
import com.ytrewq.rosLearning.repositories.Impl.TaskRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    TaskRepositoryImpl taskRepository;
    @Autowired
    CourseRepositoryImpl courseRepository;
    ModelMapper modelMapper;
    public Set<TaskDto> getAllCourseTasks(int course_id) {
        Course  course=courseRepository.findById(Course.class,course_id);
        if (course != null) {
            Set<Task> tasks = taskRepository.getAllCourseTasks(course_id);
            return tasks.stream()
                    .map(task -> modelMapper.map(task, TaskDto.class))
                    .collect(Collectors.toSet());
        }
        else throw new RuntimeException("Course not  found");
    }
    public Task getTaskById(int id){
        return taskRepository.findById(Task.class,id);
    }
}
