package com.ytrewq.rosLearning.controllers;

import com.ytrewq.rosLearning.dto.TaskDto;
import com.ytrewq.rosLearning.entities.Course;
import com.ytrewq.rosLearning.entities.Task;
import com.ytrewq.rosLearning.entities.User;
import com.ytrewq.rosLearning.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/getAllCourseTasks")
    public Set<TaskDto> getAllCourseTasks(@RequestParam int id) {
        return taskService.getAllCourseTasks(id);
    }
}
