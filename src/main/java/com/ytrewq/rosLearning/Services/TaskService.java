//package com.ytrewq.rosLearning.Services;
//
//import com.ytrewq.rosLearning.DTOs.TaskDto;
//import com.ytrewq.rosLearning.Entities.Course;
//import com.ytrewq.rosLearning.Entities.Task;
//import com.ytrewq.rosLearning.Entities.User;
//import com.ytrewq.rosLearning.Repositories.CourseRepository;
//import com.ytrewq.rosLearning.Repositories.TaskRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.Optional;
//
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
