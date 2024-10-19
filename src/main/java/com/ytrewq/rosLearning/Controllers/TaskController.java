//package com.ytrewq.rosLearning.Controllers;
//
//
//import com.ytrewq.rosLearning.DTOs.TaskDto;
//import com.ytrewq.rosLearning.Entities.User;
//import com.ytrewq.rosLearning.Services.TaskService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api")
//public class TaskController {
//    @Autowired
//    TaskService taskService;
//
//    @GetMapping("/user/getThemeTasks/{course_id}_{theme_id}")
//    public TaskDto[] getThemeTasks(@AuthenticationPrincipal User user, @RequestParam int course_id, int theme_id) {
//        return taskService.getThemeTasks(user, course_id, theme_id);
//    }
//
////    @GetMapping("/admin/getAllTasks")
////    public TaskDto[] getAllTasks() {
////        return taskService.getAllTasks();
////    }
//}
//
