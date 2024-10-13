package com.ytrewq.rosLearning.services;

import com.ytrewq.rosLearning.dto.CourseDto;
import com.ytrewq.rosLearning.entities.Course;
import com.ytrewq.rosLearning.entities.User;
import com.ytrewq.rosLearning.repositories.Impl.CourseRepositoryImpl;
import com.ytrewq.rosLearning.repositories.Impl.UserRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    CourseRepositoryImpl courseRepository;
    @Autowired
    UserRepositoryImpl userRepository;
    ModelMapper modelMapper=new ModelMapper();

    public Set<CourseDto> getAllUserCourses(int id) {
        User user = userRepository.findById(User.class, id);
        if (user != null) {
            Set<Course> courses = courseRepository.getAllUserCourses(user.getId());
            return courses.stream()
                    .map(course -> modelMapper.map(course, CourseDto.class))
                    .collect(Collectors.toSet());
        } else throw new RuntimeException("User not  found");
    }

    public Set<CourseDto> getAllCourses() {
        Set<Course> courses = courseRepository.findAll(Course.class);
        return courses.stream()
                .map(course -> modelMapper.map(course, CourseDto.class))
                .collect(Collectors.toSet());
    }

    public void createCourse(CourseDto courseDto) {
        String description = courseDto.getDescription();
        String title = courseDto.getTitle();
        LocalDateTime date_of_creation = LocalDateTime.now();
        Course course = new Course(title, date_of_creation, description, null);
        courseRepository.create(course);
    }


    public Course getCourseById(int id) {
        return courseRepository.findById(Course.class, id);

    }
}
