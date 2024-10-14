package com.ytrewq.rosLearning.Services;

import com.ytrewq.rosLearning.DTOs.TaskDto;
import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Entities.Task;
import com.ytrewq.rosLearning.Repositories.CourseRepository;
import com.ytrewq.rosLearning.Repositories.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    CourseRepository courseRepository;
    ModelMapper modelMapper = new ModelMapper();

    public TaskDto[] getAllCourseTasks(int course_id, int theme_id) {
        Optional<Course> course = courseRepository.findById(course_id);
        if (course.isPresent()) {
            Task[]tasks = taskRepository.getAllCourseTasks(course_id, theme_id);
            return Arrays.stream(tasks)
                    .map(task -> modelMapper.map(task, TaskDto.class))
                    .toArray(TaskDto[]::new);
        }
        return null;
    }

    public TaskDto[] getAllTasks() {
        List<Task> tasks = (List<Task>) taskRepository.findAll();
        return tasks.stream()
                .map(task -> modelMapper.map(task, TaskDto.class))
                .toArray(TaskDto[]::new);
    }


    public Optional<Task> getTaskById(int id) {
        return taskRepository.findById(id);
    }
}
