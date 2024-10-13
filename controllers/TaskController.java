package com.ytrewq.rosLearning.controllers;

import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.dto.TaskDto;
import com.ytrewq.rosLearning.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/user/getThemeTasks/{course_id}_{theme_id}")
    public Set<TaskDto> getAllCourseTasks(@AuthenticationPrincipal User user, @RequestParam int course_id, int theme_id) {
        return taskService.getAllCourseTasks(course_id, theme_id);
    }

    @GetMapping("/admin/getAllTasks")
    public Set<TaskDto> getAllTasks(@AuthenticationPrincipal User admin) {
        return taskService.getAllTasks();
    }
}
