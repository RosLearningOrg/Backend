package com.ytrewq.rosLearning;

import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Entities.Theme;
import com.ytrewq.rosLearning.Entities.ThemeMaterial;
import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.Repositories.CourseRepository;
import com.ytrewq.rosLearning.Repositories.ThemeMaterialRepository;
import com.ytrewq.rosLearning.Repositories.ThemeRepository;
import com.ytrewq.rosLearning.Services.AuthService;
import com.ytrewq.rosLearning.Services.ThemeMaterialService;
import com.ytrewq.rosLearning.Services.ThemeService;
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
    @Autowired
    private final ThemeRepository themeRepository;
    @Autowired
    private final ThemeService themeService;
    @Autowired
    private final ThemeMaterialRepository themeMaterialRepository;
    @Autowired
    private final ThemeMaterialService themeMaterialService;


    public MyCommandLineRunner(AuthService customUserDetailsService, PasswordEncoder passwordEncoder, CourseRepository courseRepository, UserService userService, ThemeRepository themeRepository, ThemeService themeService, ThemeMaterialRepository themeMaterialRepository, ThemeMaterialService themeMaterialService) {
        this.customUserDetailsService = customUserDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.courseRepository = courseRepository;
        this.userService = userService;
        this.themeRepository = themeRepository;
        this.themeService = themeService;
        this.themeMaterialRepository = themeMaterialRepository;
        this.themeMaterialService = themeMaterialService;
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

        Theme theme1 = new Theme("Название 1", LocalDateTime.now(), "Описание темы 1", null, null);
        Theme theme2 = new Theme("Название 2", LocalDateTime.now(), "Описание темы 2", null, null);
        Theme theme3 = new Theme("Название 3", LocalDateTime.now(), "Описание темы 3", null, null);
        Theme theme4 = new Theme("Название 4", LocalDateTime.now(), "Описание темы 4", null, null);

        themeRepository.save(theme1);
        themeRepository.save(theme2);
        themeRepository.save(theme3);
        themeRepository.save(theme4);

        themeService.addCourseTheme(course, theme1);
        themeService.addCourseTheme(course, theme2);
        themeService.addCourseTheme(course, theme4);
        themeService.addCourseTheme(course1, theme3);
        themeService.addCourseTheme(course2, theme1);

        ThemeMaterial material1 = new ThemeMaterial("Материал 1", "конспект", "ссылка в никуда", "Описание или хз что...");
        ThemeMaterial material2 = new ThemeMaterial("Материал 2", "конспект", "ссылка в никуда", "Описание или хз что...");
        ThemeMaterial material3 = new ThemeMaterial("Материал 3", "конспект", "ссылка в никуда", "Описание или хз что...");
        ThemeMaterial material4 = new ThemeMaterial("Материал 4", "конспект", "ссылка в никуда", "Описание или хз что...");
        ThemeMaterial material5 = new ThemeMaterial("Материал 5", "конспект", "ссылка в никуда", "Описание или хз что...");
        ThemeMaterial material6 = new ThemeMaterial("Материал 6", "конспект", "ссылка в никуда", "Описание или хз что...");
        ThemeMaterial material7 = new ThemeMaterial("Материал 7", "конспект", "ссылка в никуда", "Описание или хз что...");
        themeMaterialRepository.save(material1);
        themeMaterialRepository.save(material2);
        themeMaterialRepository.save(material3);
        themeMaterialRepository.save(material4);
        themeMaterialRepository.save(material5);
        themeMaterialRepository.save(material6);
        themeMaterialRepository.save(material7);



        themeMaterialService.addThemeMaterial(theme1, material1);
        themeMaterialService.addThemeMaterial(theme2, material2);
        themeMaterialService.addThemeMaterial(theme3, material3);
        themeMaterialService.addThemeMaterial(theme4, material4);
        themeMaterialService.addThemeMaterial(theme1, material5);
        themeMaterialService.addThemeMaterial(theme3, material6);
        themeMaterialService.addThemeMaterial(theme1, material7);
        themeMaterialService.addThemeMaterial(theme3, material1);
        themeMaterialService.addThemeMaterial(theme1, material7);


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("App starts correct");
    }
}