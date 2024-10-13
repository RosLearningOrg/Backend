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
    public Set<CourseDto> getAllUserCourses(@RequestParam int id) {
            return courseService.getAllUserCourses(id);

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
