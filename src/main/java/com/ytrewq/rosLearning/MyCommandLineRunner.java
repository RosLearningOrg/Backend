package com.ytrewq.rosLearning;

import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Autowired
    private final AuthService customUserDetailsService;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public MyCommandLineRunner(AuthService customUserDetailsService, PasswordEncoder passwordEncoder) {
        this.customUserDetailsService = customUserDetailsService;
        this.passwordEncoder = passwordEncoder;
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
    }
}