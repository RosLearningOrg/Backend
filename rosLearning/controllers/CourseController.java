package com.ytrewq.rosLearning.controllers;

import com.ytrewq.rosLearning.dto.CourseDto;
import com.ytrewq.rosLearning.entities.Course;
import com.ytrewq.rosLearning.entities.User;
import com.ytrewq.rosLearning.services.CourseService;
import com.ytrewq.rosLearning.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    UserService userService;

    @GetMapping("/getAllUserCourses")
    public Set<Course> getAllUserCourses(@RequestParam int id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return courseService.getAllUserCourses(user);
        }
        return null;
    }
/*    @PostMapping("/createCourse")
    public Course createCourse(CourseDto courseDto){
    return
   }*/


}
