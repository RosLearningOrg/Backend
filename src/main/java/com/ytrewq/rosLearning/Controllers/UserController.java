package com.ytrewq.rosLearning.Controllers;

import com.ytrewq.rosLearning.DTOs.UserDTO;
import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.Exeptions.AppException;
import com.ytrewq.rosLearning.Forms.ListUserForm;
import com.ytrewq.rosLearning.Forms.UserForm;
import com.ytrewq.rosLearning.Services.CourseService;
import com.ytrewq.rosLearning.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    CourseService courseService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/admin/getAllUsers")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/admin/getUserByUsername")
    public UserDTO getUserByUsername(@RequestParam(name = "username") String username) {
        UserDTO user = userService.getUserByUsername(username);
        if (user == null) {
            throw new AppException("User not found.");
        }
        return user;
    }

    @PostMapping("/admin/createUser")
    public Map<String, String> createUser(@RequestBody UserForm form) {
        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setEmail(form.getEmail());
        user.setName(form.getName());
        user.setRole(form.getRole());
        userService.save(user);

        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }

    @GetMapping("/admin/deleteUser")
    public Map<String, String> deleteUser(@RequestParam(name = "username") String username) {

        User user = userService.findByUsername(username);
        if (user == null) {
            throw new AppException("User not found.");
        }
        int userId = user.getId();
        userService.deleteUser(userId);
        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }

    @PutMapping("/admin/updateUser")
    public Map<String, String> updateUser(@RequestBody UserForm userForm) {
        User user = userService.findByUsername(userForm.getUsername());
        if (user == null) {
            throw new AppException("User not found.");
        }
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setUsername(userForm.getUsername());
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        userService.updateUser(user);

        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }

    @PutMapping("/admin/addCourseUsers")
    public Map<String, String> addCourseUsers(@RequestParam(name = "course_id") int courseId, @RequestBody ListUserForm listUserForm) {
        Course course = courseService.getCourseById(courseId);
        if (course == null) {
            throw new AppException("Course not found.");
        }
        List<User> users = new ArrayList<>();
        for (String username : listUserForm.getUsernames()) {
            User user = userService.findByUsername(username);
            if (user == null) {
                throw new AppException("User %s not found.".formatted(username));
            }
            users.add(user);
        }

        userService.setCourseUsers(course, users);
        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }

    @DeleteMapping("/admin/deleteCourseUsers")
    public Map<String, String> deleteCourseUsers(@RequestParam(name = "course_id") int courseId, @RequestBody ListUserForm listUserForm) {
        Course course = courseService.getCourseById(courseId);
        if (course == null) {
            throw new AppException("Course not found.");
        }
        List<User> users = new ArrayList<>();
        for (String username : listUserForm.getUsernames()) {
            User user = userService.findByUsername(username);
            if (user == null) {
                throw new AppException("User %s not found.".formatted(username));
            }
            users.add(user);
        }
        userService.deleteCourseUsers(course, users);
        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }

    @GetMapping("/admin/getCoursesUsers")
    public List<UserDTO> getCoursesUsers(@RequestParam(name = "course_id") int courseId) {
        return userService.getCourseUsers(courseId);
    }
}
