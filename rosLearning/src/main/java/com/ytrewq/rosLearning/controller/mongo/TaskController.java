package com.ytrewq.rosLearning.controller.mongo;

import com.ytrewq.rosLearning.entity.mongo.Task;
import com.ytrewq.rosLearning.service.mongo.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
}
