package com.ytrewq.rosLearning.Controllers;


import com.ytrewq.rosLearning.DTOs.TaskDto;
import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.Exeptions.AppException;
import com.ytrewq.rosLearning.Services.TaskService;
import com.ytrewq.rosLearning.Services.ThemeMaterialService;
import com.ytrewq.rosLearning.Services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        task.setCourseTitle(form.getCourseTitle());
        task.setLessonTitle(form.getLessonTitle());
        task.setEmulation(form.getEmulation());
        customTaskServise.save(task);

        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }
}
