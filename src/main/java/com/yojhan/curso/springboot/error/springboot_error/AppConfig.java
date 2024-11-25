package com.yojhan.curso.springboot.error.springboot_error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yojhan.curso.springboot.error.springboot_error.models.domain.User;

@Configuration
public class AppConfig {

    @Bean
    List<User> lista() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Pepe", "Gonzales"));
        users.add(new User(2L, "Maria", "Mena"));
        users.add(new User(3L, "Josefa", "Ramirez"));
        users.add(new User(4L, "Maria", "Perez"));
        users.add(new User(5L, "Ale", "Gutierrez"));

        return users;
    }
}
