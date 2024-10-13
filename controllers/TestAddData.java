package com.ytrewq.rosLearning.controllers;

import com.ytrewq.rosLearning.Entities.*;
import com.ytrewq.rosLearning.repositories.Impl.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class TestAddData {

    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    CourseRepositoryImpl courseRepository;
    @Autowired
    ThemeRepositoryImpl themeRepository;
    @Autowired
    TaskRepositoryImpl taskRepository;
    @Autowired
    UserRepositoryImpl userRepository;
    @Autowired
    ResultRepositoryImpl resultRepository;
    @Autowired
    ThemeMaterialRepositoryImpl themeMaterialRepository;
    @Autowired
    EmulationRepositoryImpl emulationRepository;

    @Transactional
    @GetMapping("/test/makeTestData")
    public String createCourse() {
        Result result = new Result("{\"Courses\": {1: {\"Themes\": {1: {\"Tasks\": {}}}}}}");
        resultRepository.create(result);

        User user = new User("admin@mail.ru", "Admin", "admin", LocalDateTime.now(), true, result, null, "admin", "12345678");
        userRepository.create(user);
        for (int i = 2; i <= 11; i++) {
            Result result1 = new Result("{\"Courses\": {1: {\"Themes\": {1: {\"Tasks\": {}}}}}}");
            resultRepository.create(result1);

            User user1 = new User("user%s@mail.ru".formatted(i), "User %s".formatted(i), "user", LocalDateTime.now(), false, result1, null, "user %s".formatted(i), "12345678");
            userRepository.create(user1);
            Task task = new Task("Название %d".formatted(i), LocalDateTime.now(), "Описание задачи %d".formatted(i), "Урок %d".formatted(i), "Курс %d".formatted(i), null);
            Emulation emulation = new Emulation("Название %d".formatted(i), LocalDateTime.now(), 1, "", "", "", "", " ", null);
            task.setEmulation(emulation);
            emulation.setTask(task);

            emulationRepository.create(emulation);
            taskRepository.create(task);
            Course course = new Course("Название %d".formatted(i), LocalDateTime.now(), "Описание курса %d".formatted(i), null);
            courseRepository.create(course);
            Theme theme = new Theme("Название %d".formatted(i), LocalDateTime.now(), "Описание темы %d".formatted(i), null, null);
            themeRepository.create(theme);

            ThemeMaterial themeMaterial = new ThemeMaterial("Название материала", "Тип материала", "", "Описание материала");
            themeMaterialRepository.create(themeMaterial);

        }

        Set<Course> courseList = courseRepository.findAll(Course.class);
        User user2 = userRepository.findById(User.class, 10);
        user.setCourses(courseList);
        userRepository.update(user2);
        Theme theme = themeRepository.findById(Theme.class, 10);
        Set<Task> tasks = taskRepository.findAll(Task.class);
        Set<ThemeMaterial> themeMaterials = themeMaterialRepository.findAll(ThemeMaterial.class);
        theme.setTasks(tasks);
        theme.setMaterials(themeMaterials);
        themeRepository.update(theme);
        Course course = courseRepository.findById(Course.class, 10);

        Set<Theme> themes = themeRepository.findAll(Theme.class);
        course.setThemes(themes);
        courseRepository.update(course);






        return "OK";
    }
}



