package com.ytrewq.rosLearning.Controllers;


import com.ytrewq.rosLearning.DTOs.CourseDto;
import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Forms.CourseForm;
import com.ytrewq.rosLearning.Services.CourseService;
import com.ytrewq.rosLearning.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private final CourseService customCourseService;
    @Autowired
    private final UserService userService;

    public CourseController(CourseService customCourseService, UserService userService) {
        this.customCourseService = customCourseService;
        this.userService = userService;
    }

    @GetMapping("/getAllUserCourses")
    public Set<CourseDto> getAllUserCourses(@RequestParam int id) {
        return customCourseService.getAllUserCourses(id);

    }

    @GetMapping("/getAllCourses")
    public Set<CourseDto> getAllCourses() {
        return customCourseService.getAllCourses();

    }
/*    @PostMapping("/createCourse")
    public Course createCourse(CourseDto courseDto){
    return
   }*/
    @PostMapping("/api/admin/createCourse")
    public Map<String, String> createCourse(@RequestBody CourseForm form){
        Course course = new Course();
        course.setTitle(form.getTitle());
        course.setDateOfCreation(LocalDateTime.now());
        course.setDescription(form.getDescription());
        customCourseService.save(course);

        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }
}
