package com.ytrewq.rosLearning.Controllers;


import com.ytrewq.rosLearning.DTOs.TaskDto;
import com.ytrewq.rosLearning.Entities.Task;
import com.ytrewq.rosLearning.Entities.Theme;
import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.Exeptions.AppException;
import com.ytrewq.rosLearning.Forms.TaskForm;
import com.ytrewq.rosLearning.Services.TaskService;
import com.ytrewq.rosLearning.Services.ThemeMaterialService;
import com.ytrewq.rosLearning.Services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    ThemeMaterialService themeMaterialService;
    @Autowired
    TaskService taskService;

    @Autowired
    ThemeService themeService;

    @GetMapping("/user/getThemeTasks")
    public List<TaskDto> getThemeTasks(@AuthenticationPrincipal User user,
                                       @RequestParam(name = "course_id") int courseId,
                                       @RequestParam(name = "theme_id") int themeId) {
        List<TaskDto> tasks = taskService.getThemeTasks(user, courseId, themeId);
        if (tasks == null) {
            throw new AppException("Theme not allow for user");
        }
        return tasks;
    }

    @GetMapping("/admin/getThemeTasks")
    public List<TaskDto> getThemeTasksAdmin(@AuthenticationPrincipal User user,
                                            @RequestParam(name = "theme_id") int themeId) {
        List<TaskDto> tasks = taskService.getThemeTasksAdmin(themeId);
        if (tasks == null) {
            throw new AppException("Theme is not exists");
        }
        return tasks;
    }

    @GetMapping("/admin/getAllTasks")
    public List<TaskDto> getAllTasks(@AuthenticationPrincipal User user) {
        return taskService.getAllTasks();
    }

    @PostMapping("/admin/createTask")
    public Map<String, String> createCourse(@RequestBody TaskForm form) {
        Task task = new Task();
        task.setTitle(form.getTitle());
        task.setDateOfCreation(LocalDateTime.now());
        task.setDescription(form.getDescription());
        task.setEmulation(form.getEmulation());
        taskService.save(task);

        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }


    @GetMapping("/admin/removeThemeTask")
    public Map<String, String> removeThemeTask(@RequestParam(name = "theme_id") int themeId,
                                               @RequestParam(name = "task_id") int taskId) {

        Theme theme = themeService.getThemeAdmin(themeId);
        if (theme == null) {
            throw new AppException("Theme not found.");
        }


        if (!taskService.existsById(taskId)) {
            throw new AppException("Task not found.");
        }

        taskService.removeThemeTask(theme, taskId);

        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }
}
