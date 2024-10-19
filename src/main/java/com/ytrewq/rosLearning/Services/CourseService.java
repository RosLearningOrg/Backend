package com.ytrewq.rosLearning.Services;

import com.ytrewq.rosLearning.DTOs.CourseDto;
import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.Repositories.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    UserService userService;

    ModelMapper modelMapper = new ModelMapper();

    public List<CourseDto> getUserCourses(User currentUser) {
        List<Course> courses = userService.getUserCourses(currentUser);
        return courses.stream().map(course -> modelMapper.map(course, CourseDto.class)).toList();
    }

    public List<CourseDto> getAllCourses() {
        Set<Course> courses = courseRepository.findAll();
        return courses.stream().map(course -> modelMapper.map(course, CourseDto.class)).toList();
    }

    public Course getCourseById(int courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        return course.orElse(null);
    }

    public void save(Course course) {
        courseRepository.save(course);
    }
}
