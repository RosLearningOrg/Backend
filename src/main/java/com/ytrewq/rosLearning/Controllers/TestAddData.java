//package com.ytrewq.rosLearning.Controllers;
//
//import com.ytrewq.rosLearning.Entities.*;
//import com.ytrewq.rosLearning.Repositories.*;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.LocalDateTime;
//import java.util.Set;
//
//@RestController
//@RequestMapping("/api")
//public class TestAddData {
//
//    @PersistenceContext
//    EntityManager entityManager;
//    @Autowired
//    CourseRepository courseRepository;
//    @Autowired
//    ThemeRepository themeRepository;
//    @Autowired
//    TaskRepository taskRepository;
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    ResultRepository resultRepository;
//    @Autowired
//    ThemeMaterialRepository themeMaterialRepository;
//    @Autowired
//    EmulationRepository emulationRepository;
//
//    @Transactional
//    @GetMapping("/test/makeTestData")
//    public String createCourse() {
//        Result result = new Result("{\"Courses\": {1: {\"Themes\": {1: {\"Tasks\": {}}}}}}");
//        resultRepository.create(result);
//
//        User user = new User("admin@mail.ru", "Admin", "admin", LocalDateTime.now(), true, result, null, "admin", "12345678");
//        userRepository.create(user);
//        for (int i = 2; i <= 11; i++) {
//            Result result1 = new Result("{\"Courses\": {1: {\"Themes\": {1: {\"Tasks\": {}}}}}}");
//            resultRepository.create(result1);
//
//            User user1 = new User("user%s@mail.ru".formatted(i), "User %s".formatted(i), "user", LocalDateTime.now(), false, result1, null, "user %s".formatted(i), "12345678");
//            userRepository.create(user1);
//            Task task = new Task("Название %d".formatted(i), LocalDateTime.now(), "Описание задачи %d".formatted(i), "Урок %d".formatted(i), "Курс %d".formatted(i), null);
//            Emulation emulation = new Emulation("Название %d".formatted(i), LocalDateTime.now(), 1, "", "", "", "", " ", null);
//            task.setEmulation(emulation);
//            emulation.setTask(task);
//
//            emulationRepository.create(emulation);
//            taskRepository.create(task);
//            Course course = new Course("Название %d".formatted(i), LocalDateTime.now(), "Описание курса %d".formatted(i), null);
//            courseRepository.create(course);
//            Theme theme = new Theme("Название %d".formatted(i), LocalDateTime.now(), "Описание темы %d".formatted(i), null, null);
//            themeRepository.create(theme);
//
//            ThemeMaterial themeMaterial = new ThemeMaterial("Название материала", "Тип материала", "", "Описание материала");
//            themeMaterialRepository.create(themeMaterial);
//
//        }
//
//        Set<Course> courseList = courseRepository.findAll(Course.class);
//        Course[] courseArray = courseList.toArray(new Course[0]);
//
//        User user2 = userRepository.findById(User.class, 10);
//        user.setCourses(courseArray);
//        userRepository.update(user2);
//        Theme theme = themeRepository.findById(Theme.class, 10);
//        Set<Task> tasks = taskRepository.findAll(Task.class);
//        Task[] taskArray = tasks.toArray(new Task[0]);
//
//        Set<ThemeMaterial> themeMaterials = themeMaterialRepository.findAll(ThemeMaterial.class);
//
//        ThemeMaterial[] themeMaterialsArray = themeMaterials.toArray(new ThemeMaterial[0]);
//
//        theme.setTasks(taskArray);
//        theme.setMaterials(themeMaterialsArray);
//        themeRepository.update(theme);
//        Course course = courseRepository.findById(10);
//
//        Set<Theme> themes = themeRepository.findAll(Theme.class);
//        Theme[] themesArray = themes.toArray(new Theme[0]);
//
//        course.setThemes(themesArray);
//        courseRepository.update(course);
//        return "OK";
//    }
//}
//
//
//
