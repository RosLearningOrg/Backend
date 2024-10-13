package com.ytrewq.rosLearning.controllers;

import com.ytrewq.rosLearning.DTOs.UserDTO;
import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.Exeptions.AppException;
import com.ytrewq.rosLearning.Forms.LoginForm;
import com.ytrewq.rosLearning.Forms.RegisterForm;
import com.ytrewq.rosLearning.Services.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api")
@DependsOn("securityFilterChain")
public class AuthController {
    @Autowired
    private final RememberMeServices rememberMeServices;
    @Autowired
    private final AuthService customUserDetailsService;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public AuthController(RememberMeServices rememberMeServices, AuthService customUserDetailsService,
                          PasswordEncoder passwordEncoder) {
        this.rememberMeServices = rememberMeServices;
        this.customUserDetailsService = customUserDetailsService;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/login")
    public Map<String, String> login(@Valid @RequestBody LoginForm form, BindingResult bindingResult,
                                     HttpServletRequest request, HttpServletResponse response) {
        if (request.getUserPrincipal() != null) {
            throw new AppException("Please logout first.");
        }

        if (bindingResult.hasErrors()) {
            throw new AppException("Invalid username or password");
        }

        try {
            request.login(form.getUsername(), form.getPassword());
        } catch (ServletException e) {
            throw new AppException("Invalid username or password");
        }

        var auth = (Authentication) request.getUserPrincipal();
        rememberMeServices.loginSuccess(request, response, auth);

        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }

    @GetMapping("/csrf")
    public CsrfResponse csrf(HttpServletRequest request) {
        var csrf = (CsrfToken) request.getAttribute("_csrf");
        return new CsrfResponse(csrf.getToken());
    }

    @PostMapping("/signup")
    public Map<String, String> authenticateUser(@RequestBody RegisterForm form, BindingResult bindingResult,
                                                HttpServletRequest request, HttpServletResponse response) {
        if (request.getUserPrincipal() != null) {
            throw new AppException("Please logout first.");
        }

        if (customUserDetailsService.existsByUsername(form.getUsername())) {
            throw new AppException("Username is already taken.", 400);
        }

        if (customUserDetailsService.existsByEmail(form.getEmail())) {
            throw new AppException("Email is already taken.", 400);
        }

        User user = new User();
        user.setName(form.getName());
        user.setUsername(form.getUsername());
        user.setEmail(form.getEmail());
        user.setRole(form.getRole());
        user.setDateOfRegistration(LocalDateTime.now());
        user.setAdmin(false);
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        customUserDetailsService.save(user);

        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }

    @PostMapping("/logout")
    public Map<String, String> logout(HttpServletRequest request) throws ServletException {
        request.logout();

        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }

    @GetMapping("/current-user")
    public UserDTO getCurrentUser(@AuthenticationPrincipal User user) {
        return new UserDTO(user.getUsername(), user.getEmail(), user.getName(),
                user.getRole(), user.getDateOfRegistration(), user.isAdmin());
    }
    public record CsrfResponse(String token) {
    }
}