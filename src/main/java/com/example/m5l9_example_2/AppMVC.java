package com.example.m5l9_example_2;

import com.example.m5l9_example_2.entity.User;
import com.example.m5l9_example_2.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class AppMVC {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(AppMVC.class, args);

        UserService userService = run.getBean(UserService.class);
        List<User> all = userService.findAll();
        for (User user : all) {
            System.out.println(user);
        }

        User user = userService.findById(1L).orElseThrow();
        System.out.println(user);



    }
}
