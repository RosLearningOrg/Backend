//package com.ytrewq.rosLearning.Controllers;
//
//import com.ytrewq.rosLearning.Entities.User;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api")
//public class TemplateController {
//    @GetMapping("/test")
//    public String test(@AuthenticationPrincipal User user) {
//        System.out.println(user);
//        System.out.println(user.getName() + " " + user.getRole());
//        return "запрос с общим доступом";
//    }
//
//    @GetMapping("/test-user")
//    public String test_user(@AuthenticationPrincipal User user) {
//        System.out.println(user);
//        System.out.println(user.getName() + " " + user.getRole() + " и он пользователь");
//        return "запрос с доступом только пользователя";
//    }
//
//    @GetMapping("/test-admin")
//    public String test_admin(@AuthenticationPrincipal User user) {
//        System.out.println(user);
//        System.out.println(user.getName() + " " + user.getRole() + " и он админ");
//        return "запрос с доступом только админа";
//    }
//}
