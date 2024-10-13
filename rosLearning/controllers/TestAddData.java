package com.ytrewq.rosLearning.controllers;

import com.ytrewq.rosLearning.dto.CourseDto;
import com.ytrewq.rosLearning.entities.*;
import com.ytrewq.rosLearning.repositories.Impl.*;
import com.ytrewq.rosLearning.services.CourseService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Set;

@RestController
@RequestMapping("/create")
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
    EmulationRepositoryImpl emulationRepository;

    @Transactional
    @GetMapping("/addCourses")
    public String createCourse() {
/*        Result result = new Result("{\"Courses\": {1: {\"Themes\": {1: {\"Tasks\": {}}}}}}");
        resultRepository.create(result);

        User user = new User("admin@mail.ru", "Admin", "admin", null, true, result, null);
        userRepository.create(user);*/
        for (int i = 1; i <= 10; i++) {
/*            Result result = new Result("{\"Courses\": {1: {\"Themes\": {1: {\"Tasks\": {}}}}}}");
            resultRepository.create(result);

            User user = new User("test%d@mail.ru".formatted(i), "Name %d".formatted(i), "user", null, false, result, null);
            userRepository.create(user);*/
            Task task = new Task("Название %d".formatted(i), LocalDateTime.now(), "Описание задачи %d".formatted(i), "Урок %d".formatted(i), "Курс %d".formatted(i));
            Emulation emulation = new Emulation("Название %d".formatted(i), LocalDateTime.now(), 1, "", "","",""," ");
            task.setEmulation(emulation);
            emulation.setTask(task);

            emulationRepository.create(emulation);
            taskRepository.create(task);
        }

        return "OK";
    }
}
   /*       Theme theme = new Theme("Название %d".formatted(i), LocalDateTime.now(), "Описание темы %d".formatted(i), null, null);
            Task task = new Task("Название %d".formatted(i), LocalDateTime.now(), "Описание темы %d".formatted(i), null, null);
            Course course = new Course("Название %d".formatted(i), LocalDateTime.now(), "Описание курса %d".formatted(i), null);
            courseRepository.create(course);
        }
        return courseRepository.findAll(Course.class)*/


   /* @PostMapping("/addThemes")
    public Set<Theme> createTheme(){
        for (int i=1; i<=10;i++) {
            Theme theme = new Theme("Название %d".formatted(i), LocalDateTime.now(), "Описание темы %d".formatted(i), null, null);
            themeRepository.create(theme);
        }
        return themeRepository.findAll(Theme.class)

    }
    @PostMapping("/addTasks")
    public Set<Theme> createTheme(){
        for (int i=1; i<=10;i++) {
            Task task = new Theme("Название %d".formatted(i), LocalDateTime.now(), "Описание темы %d".formatted(i), null, null);
            themeRepository.create(theme);
        }
        return themeRepository.findAll(Theme.class)

    }
*/


