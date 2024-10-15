package com.ytrewq.rosLearning.Services;

import com.ytrewq.rosLearning.DTOs.CourseDto;
import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Repositories.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    ModelMapper modelMapper = new ModelMapper();

    public CourseDto[] getAllUserCourses(int id) {
        Course[] courses = courseRepository.getAllUserCourses(id);
        return Arrays.stream(courses).map(course -> modelMapper.map(course, CourseDto.class))
                .toArray(CourseDto[]::new);

    }

    public CourseDto[] getAllCourses() {
        List<Course> courses = (List<Course>) courseRepository.findAll();
        return courses.stream()
                .map(course -> modelMapper.map(course, CourseDto.class))
                .toArray(CourseDto[]::new);

    }

    public void saveCourse(CourseDto courseDto) {
        String description = courseDto.getDescription();
        String title = courseDto.getTitle();
        LocalDateTime date_of_creation = LocalDateTime.now();
        Course course = new Course(title, date_of_creation, description, null);
        courseRepository.save(course);
    }


    public CourseDto getCourseById(int id) {
        if (courseRepository.findById(id).isPresent()){
            return modelMapper.map(courseRepository.findById(id),CourseDto.class);
        }


    }
}
