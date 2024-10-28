package com.ytrewq.rosLearning.Services;

import com.ytrewq.rosLearning.DTOs.TaskDto;
import com.ytrewq.rosLearning.Entities.Task;
import com.ytrewq.rosLearning.Entities.Theme;
import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.Repositories.TaskRepository;
import com.ytrewq.rosLearning.Repositories.ThemeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private final TaskRepository taskRepository;
    @Autowired
    private final ThemeRepository themeRepository;
    @Autowired
    private final ThemeService themeService;

    ModelMapper modelMapper = new ModelMapper();


    public TaskService(TaskRepository taskRepository, ThemeRepository themeRepository, ThemeService themeService) {
        this.taskRepository = taskRepository;
        this.themeRepository = themeRepository;
        this.themeService = themeService;
    }

    public List<Task> getThemeTasks(Theme theme) {
        String[] tasksIdsStr = theme.getTasksIdsStr().split("/;/");
        List<Integer> tasksIds = new ArrayList<>();
        for (String s : tasksIdsStr) {
            if (!s.isEmpty()) {
                tasksIds.add(Integer.parseInt(s));
            }
        }
        return (List<Task>) taskRepository.findAllById(tasksIds);
    }

    public void setThemeTasks(Theme theme, List<Task> tasks) {
        List<String> tasksIdsStr = new ArrayList<>();
        for (Task task : tasks) {
            tasksIdsStr.add(String.valueOf(task.getId()));
        }
        theme.setTasksIdsStr(String.join("/;/", tasksIdsStr));
        themeRepository.save(theme);
    }

    public Task getThemeTask(Theme theme, Integer taskId) {
        String taskIdStr = taskId.toString();
        if (("/;/" + theme.getTasksIdsStr() + "/;/").contains("/;/" + taskIdStr + "/;/")) {
            Optional<Task> task = taskRepository.findById(taskId);
            return task.orElse(null);
        }
        return null;
    }

    public void addThemeTask(Theme theme, Task task) {
        addThemeTask(theme, task.getId());
    }
    public void addThemeTask(Theme theme, Integer taskId) {
        String taskIdStr = String.valueOf(taskId);
        if (theme.getTasksIdsStr() == null) {
            theme.setTasksIdsStr("");
        }
        if (!theme.getTasksIdsStr().isEmpty()) {
            theme.setTasksIdsStr(theme.getTasksIdsStr() + "/;/" + taskId);
        } else {
            theme.setTasksIdsStr(taskIdStr);
        }
        themeRepository.save(theme);
    }

    public void removeThemeTask(Theme theme, Integer taskId) {
        String taskIdStr = taskId.toString();
        String tasksIdsStr = theme.getTasksIdsStr();
        tasksIdsStr = "/;/" + tasksIdsStr + "/;/";
        tasksIdsStr = tasksIdsStr.replace("/;/" + taskIdStr + "/;/", "/;/");
        if (!tasksIdsStr.equals("/;/")) {
            tasksIdsStr = tasksIdsStr.substring(3, tasksIdsStr.length() - 3);
        } else {
            tasksIdsStr = "";
        }
        theme.setTasksIdsStr(tasksIdsStr);
        themeRepository.save(theme);

    }

    public List<TaskDto> getThemeTasks(User currentUser, Integer courseId, Integer themeId) {
        Theme theme = themeService.getCourseTheme(currentUser, courseId, themeId);
        if (theme != null) {
            return getThemeTasks(theme).stream().map(task -> modelMapper.map(task, TaskDto.class)).toList();
        }
        return null;
    }

    public List<TaskDto> getThemeTasksAdmin(Integer themeId) {
        Theme theme = themeService.getThemeAdmin(themeId);
        if (theme != null) {
            return getThemeTasks(theme).stream().map(task -> modelMapper.map(task, TaskDto.class)).toList();
        }
        return null;
    }

    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll().stream().map(task -> modelMapper.map(task, TaskDto.class)).toList();
    }

    public boolean existsById(Integer themeId) {
        return themeRepository.existsById(themeId);
    }

    public void save(Task task) {
        taskRepository.save(task);
    }
}
