package com.ytrewq.rosLearning.Controllers;


import com.ytrewq.rosLearning.DTOs.TaskDto;
import com.ytrewq.rosLearning.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getAllTasks")
    public Set<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }
}
