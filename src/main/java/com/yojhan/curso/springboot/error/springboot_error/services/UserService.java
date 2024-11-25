package com.yojhan.curso.springboot.error.springboot_error.services;

import java.util.List;
import java.util.Optional;

import com.yojhan.curso.springboot.error.springboot_error.models.domain.User;

public interface UserService {

    List<User> findByAll();

    Optional<User> findById(Long id);
}
