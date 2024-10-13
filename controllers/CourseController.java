package com.ytrewq.rosLearning.controllers;

import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.dto.CourseDto;
import com.ytrewq.rosLearning.services.CourseService;
import com.ytrewq.rosLearning.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    UserService userService;

    @GetMapping("/user/getUserCourses")
    public Set<CourseDto> getAllUserCourses(@AuthenticationPrincipal User user) {
        return courseService.getAllUserCourses(user.getId());

    }

    @GetMapping("/getAllCourses")
    public Set<CourseDto> getAllCourses() {
        return courseService.getAllCourses();

    }
/*    @PostMapping("/createCourse")
    public Course createCourse(CourseDto courseDto){
    return
   }*/


}
