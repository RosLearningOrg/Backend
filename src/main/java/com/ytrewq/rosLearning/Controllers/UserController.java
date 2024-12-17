package com.ytrewq.rosLearning.Controllers;

import com.ytrewq.rosLearning.DTOs.CourseDto;
import com.ytrewq.rosLearning.DTOs.UserDTO;
import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.Exeptions.AppException;
import com.ytrewq.rosLearning.Forms.CourseForm;
import com.ytrewq.rosLearning.Forms.UserForm;
import com.ytrewq.rosLearning.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/admin/getAllUsers")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/admin/getUserByUsername")
    public UserDTO getUserByUsername(@RequestParam(name = "username") String username){
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
        user.setPassword(form.getPassword());
        user.setEmail(form.getEmail());
        user.setName(form.getName());
        user.setRole(form.getRole());
        userService.save(user);

        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }
}
