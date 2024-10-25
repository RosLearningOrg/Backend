package com.ytrewq.rosLearning.Controllers;


import com.ytrewq.rosLearning.DTOs.CourseDto;
import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.Forms.CourseForm;
import com.ytrewq.rosLearning.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/user/getUserCourses")
    public List<CourseDto> getUserCourses(@AuthenticationPrincipal User user) {
        return courseService.getUserCourses(user);
    }

    @GetMapping("/admin/getAllCourses")
    public List<CourseDto> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping("/admin/createCourse")
    public Map<String, String> createCourse(@RequestBody CourseForm form) {
        Course course = new Course();
        course.setTitle(form.getTitle());
        course.setDateOfCreation(LocalDateTime.now());
        course.setDescription(form.getDescription());
        courseService.save(course);

        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }
}
