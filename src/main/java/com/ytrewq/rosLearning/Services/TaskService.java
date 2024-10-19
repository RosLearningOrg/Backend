package com.ytrewq.rosLearning.Services;

import com.ytrewq.rosLearning.DTOs.TaskDto;
import com.ytrewq.rosLearning.DTOs.ThemeMaterialDto;
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
    private final UserService userService;
    @Autowired
    private final ThemeService themeService;

    ModelMapper modelMapper = new ModelMapper();


    public TaskService(TaskRepository taskRepository, ThemeRepository themeRepository, UserService userService, ThemeService themeService) {
        this.taskRepository = taskRepository;
        this.themeRepository = themeRepository;
        this.userService = userService;
        this.themeService = themeService;
    }

    public List<Task> getThemeTasks(Theme theme) {
        String[] tasksIdsStr = theme.getTasksIdsStr().split("/;/");
        List<Integer> tasksIds = new ArrayList<>();
        for (String s : tasksIdsStr) {
            tasksIds.add(Integer.parseInt(s));
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
        for (String taskIdStrI : theme.getTasksIdsStr().split("/;/")) {
            if (taskIdStrI.equals(taskIdStr)) {
                Optional<Task> task = taskRepository.findById(taskId);
                return task.orElse(null);
            }
        }
        return null;
    }

    public void addThemeTask(Theme theme, Task task) {
        String taskId = String.valueOf(task.getId());
        if (theme.getTasksIdsStr() == null) {
            theme.setTasksIdsStr("");
        }
        if (!theme.getTasksIdsStr().isEmpty()) {
            theme.setTasksIdsStr(theme.getTasksIdsStr() + "/;/" + taskId);
        } else {
            theme.setTasksIdsStr(taskId);
        }
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
}


//@Service
//public class TaskService {
//    @Autowired
//    TaskRepository taskRepository;
//    @Autowired
//    CourseRepository courseRepository;
//    @Autowired
//    CourseService courseService;
//    ModelMapper modelMapper = new ModelMapper();
//
//    public TaskDto[] getThemeTasks(User user, int course_id, int theme_id) {
//        Course course = courseService.getUserCourseById(user, course_id);
//        if (course == null) {
//            return null;
//        }
//
//        System.out.println(Arrays.toString(course.getThemes()));
//
////        Task[] tasks = taskRepository.getAllCourseTasks(course_id, theme_id);
////        return Arrays.stream(tasks)
////                .map(task -> modelMapper.map(task, TaskDto.class))
////                .toArray(TaskDto[]::new);
//        return null;
//
//    }
////
////    public TaskDto[] getAllCourseTasks(int course_id, int theme_id) {
////        Optional<Course> course = courseRepository.findById(course_id);
////        if (course.isPresent()) {
////            Task[]tasks = taskRepository.getAllCourseTasks(course_id, theme_id);
////            return Arrays.stream(tasks)
////                    .map(task -> modelMapper.map(task, TaskDto.class))
////                    .toArray(TaskDto[]::new);
////        }
////        return null;
////    }
//
////    public TaskDto[] getAllTasks() {
////        List<Task> tasks = (List<Task>) taskRepository.findAll();
////        return tasks.stream()
////                .map(task -> modelMapper.map(task, TaskDto.class))
////                .toArray(TaskDto[]::new);
////    }
////
////
////    public Optional<Task> getTaskById(int id) {
////        return taskRepository.findById(id);
////    }
//}
