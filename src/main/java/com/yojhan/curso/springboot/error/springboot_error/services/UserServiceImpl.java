package com.yojhan.curso.springboot.error.springboot_error.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yojhan.curso.springboot.error.springboot_error.models.domain.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private List<User> users;

    /*
     * public UserServiceImpl() {
     * this.users = new ArrayList<>();
     * users.add(new User(1L, "Pepe", "Gonzales"));
     * users.add(new User(2L, "Maria", "Mena"));
     * users.add(new User(3L, "Josefa", "Ramirez"));
     * users.add(new User(4L, "Maria", "Perez"));
     * users.add(new User(5L, "Ale", "Gutierrez"));
     * }Sin iyectar
     */

    @Override
    public List<User> findByAll() {

        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        // Optional<User> user = users.stream().filter(usr ->
        // usr.getId().equals(id)).findFirst();

        /*
         * for (User u : users) {
         * if (u.getId().equals(id)) {// equals es por objetos
         * user = u;
         * break;
         * }
         * }
         */
        // return Optional.ofNullable(user);
        // return user; o
        return users.stream().filter(usr -> usr.getId().equals(id)).findFirst();

    }

}
