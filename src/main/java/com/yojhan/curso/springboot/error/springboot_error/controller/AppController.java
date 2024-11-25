package com.yojhan.curso.springboot.error.springboot_error.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yojhan.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.yojhan.curso.springboot.error.springboot_error.models.domain.User;
import com.yojhan.curso.springboot.error.springboot_error.services.UserService;

@RestController
@RequestMapping
public class AppController {
    @Autowired
    private UserService service;

    @GetMapping
    public String index() {
        // int values = 100 / 0;
        int values = Integer.parseInt("10x");
        System.out.println(values);
        return "ok 200";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable Long id) {
        User user = service.findById(id).orElseThrow(() -> new UserNotFoundException("El usuario no existe"));
        /*
         * if (user == null) {
         * throw new UserNotFoundException("El usuario no existe");
         * }
         */
        System.out.println(user.getLastname());

        return user;
    }

    // otra manera
    /*
     * @GetMapping("/show/{id}")
     * public responseEntity<?> show(@PathVariable Long id) {
     * Optional<User> optionalUser = service.findByAid(id);
     * if(optional.esEmpty()){
     * return responseEntity.notFound().build();
     * }
     * return responseEntity.ok(optionalUser.get())
     */
}
