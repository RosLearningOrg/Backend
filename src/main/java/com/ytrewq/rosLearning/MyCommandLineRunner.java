package com.ytrewq.rosLearning;

import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.Repositories.CourseRepository;
import com.ytrewq.rosLearning.Services.AuthService;
import com.ytrewq.rosLearning.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Autowired
    private final AuthService customUserDetailsService;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final CourseRepository courseRepository;
    @Autowired
    private final UserService userService;

    public MyCommandLineRunner(AuthService customUserDetailsService, PasswordEncoder passwordEncoder, CourseRepository courseRepository, UserService userService) {
        this.customUserDetailsService = customUserDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.courseRepository = courseRepository;
        this.userService = userService;
    }

    @Override
    public void run(String... args) {
        User user = new User();
        user.setName("Иванов Иван Иванович");
        user.setUsername("admin");
        user.setEmail("admin@admin.admin");
        user.setRole("Штатный дебил");
        user.setDateOfRegistration(LocalDateTime.now());
        user.setAdmin(true);
        user.setPassword(passwordEncoder.encode("admin"));
        customUserDetailsService.save(user);

        User user1 = new User();
        user1.setName("Дмитриев Дмитрий Дмитриевич");
        user1.setUsername("user");
        user1.setEmail("user@user.user");
        user1.setRole("Штатный не дебил");
        user1.setDateOfRegistration(LocalDateTime.now());
        user1.setAdmin(false);
        user1.setPassword(passwordEncoder.encode("user"));
        customUserDetailsService.save(user1);

        Course course = new Course("Название 1", LocalDateTime.now(), "Описание курса 1", null);
        courseRepository.save(course);
        Course course1 = new Course("Название 2", LocalDateTime.now(), "Описание курса 2", null);
        courseRepository.save(course1);
        Course course2 = new Course("Название 3", LocalDateTime.now(), "Описание курса 3", null);
        courseRepository.save(course2);

        List<Course> la = List.of(course, course1, course2);


        userService.setUserCourses(user, la);
    }
}