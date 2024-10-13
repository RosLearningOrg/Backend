package com.ytrewq.rosLearning.Controllers;


import com.ytrewq.rosLearning.DTOs.CourseDto;
import com.ytrewq.rosLearning.Services.CourseService;
import com.ytrewq.rosLearning.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
