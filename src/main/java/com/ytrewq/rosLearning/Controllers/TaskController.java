package com.ytrewq.rosLearning.Controllers;


import com.ytrewq.rosLearning.DTOs.TaskDto;
import com.ytrewq.rosLearning.Entities.Task;
import com.ytrewq.rosLearning.Forms.TaskForm;
import com.ytrewq.rosLearning.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService customTaskServise;
    @Autowired
    TaskService taskService;

    public TaskController(TaskService customTaskServise) {
        this.customTaskServise = customTaskServise;
    }

    @GetMapping("/getAllCourseTasks")
    public Set<TaskDto> getAllCourseTasks(@RequestParam int id) {
        return taskService.getAllCourseTasks(id);
    }

    @GetMapping("/getAllTasks")
    public Set<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }
    @PostMapping("/admin/createTask")
    public Map<String, String> createCourse(@RequestBody TaskForm form){
        Task task = new Task();
        task.setTitle(form.getTitle());
        task.setDateOfCreation(LocalDateTime.now());
        task.setDescription(form.getDescription());
        task.setCourseTitle(form.getCourseTitle());
        task.setLessonTitle(form.getLessonTitle());
        task.setEmulation(form.getEmulation());
        customTaskServise.save(task);

        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }
}
