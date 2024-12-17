package com.ytrewq.rosLearning.Services;

import com.ytrewq.rosLearning.DTOs.UserDTO;
import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.Repositories.CourseRepository;
import com.ytrewq.rosLearning.Repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final CourseRepository courseRepository;
    ModelMapper modelMapper = new ModelMapper();

    public UserService(UserRepository userRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    public List<Course> getUserCourses(User currentUser) {
        String[] coursesIdsStr = userRepository.findCoursesIdsStrById(currentUser.getId()).split("/;/");

        List<Integer> coursesIds = new ArrayList<>();
        for (String s : coursesIdsStr) {
            if (!s.isEmpty()) {
                coursesIds.add(Integer.parseInt(s));
            }
        }
        return (List<Course>) courseRepository.findAllById(coursesIds);
    }

    public void setUserCourses(User currentUser, List<Course> courses) {
        List<String> coursesIdsStr = new ArrayList<>();
        for (Course course : courses) {
            coursesIdsStr.add(String.valueOf(course.getId()));
        }
        currentUser.setCoursesIdsStr(String.join("/;/", coursesIdsStr));
        userRepository.save(currentUser);
    }

    public void setCourseUsers(Course course, List<User> users) {
        for (User user : users) {
            addUserCourse(user, course.getId());
        }
    }

    public void deleteCourseUsers(Course course, List<User> users) {
        for (User user : users) {
            removeUserCourse(user, course.getId());
        }
    }

    public List<UserDTO> getCourseUsers(Integer courseId) {
        String courseIdStr = courseId.toString();
        Set<User> users = userRepository.findAll();
        Set<User> resultUsers = new HashSet<>();
        for (User user : users) {
            if (("/;/" + userRepository.findCoursesIdsStrById(user.getId()) + "/;/").contains("/;/" + courseIdStr + "/;/")) {
                resultUsers.add(user);
            }

        }
        return resultUsers.stream().map(user -> modelMapper.map(user, UserDTO.class)).toList();
    }

    public Course getUserCourse(User currentUser, Integer courseId) {
        String courseIdStr = courseId.toString();
        if (("/;/" + userRepository.findCoursesIdsStrById(currentUser.getId()) + "/;/").contains("/;/" + courseIdStr + "/;/")) {
            Optional<Course> course = courseRepository.findById(courseId);
            return course.orElse(null);
        }
        return null;
    }

    public void addUserCourse(User currentUser, Integer courseId) {
        String courseIdStr = String.valueOf(courseId);
        String coursesIdsStr = userRepository.findCoursesIdsStrById(currentUser.getId());
        if (coursesIdsStr == null) {
            currentUser.setCoursesIdsStr("");
            coursesIdsStr = "";
        }
        if (!coursesIdsStr.isEmpty()) {
            currentUser.setCoursesIdsStr(coursesIdsStr + "/;/" + courseIdStr);
        } else {
            currentUser.setCoursesIdsStr(courseIdStr);
        }
        userRepository.save(currentUser);
    }

    public void removeUserCourse(User currentUser, Integer courseId) {
        String courseIdStr = courseId.toString();
        String coursesIdsStr = userRepository.findCoursesIdsStrById(currentUser.getId());
        coursesIdsStr = "/;/" + coursesIdsStr + "/;/";
        coursesIdsStr = coursesIdsStr.replace("/;/" + courseIdStr + "/;/", "/;/");
        if (!coursesIdsStr.equals("/;/")) {
            coursesIdsStr = coursesIdsStr.substring(3, coursesIdsStr.length() - 3);
        } else {
            coursesIdsStr = "";
        }
        currentUser.setCoursesIdsStr(coursesIdsStr);
        userRepository.save(currentUser);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public List<UserDTO> getAllUsers() {
        Set<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDTO.class)).toList();
    }

    public UserDTO getUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(value -> modelMapper.map(value, UserDTO.class)).orElse(null);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public boolean existsById(Integer userId) {
        return userRepository.existsById(userId);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }
}
