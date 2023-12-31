package ru.java.JavaSpringBoot.service;



import ru.java.JavaSpringBoot.model.User;

import java.util.List;

public interface UserService {


    List<User> getUserList();
    void saveUser(User user);

    User getUser(Long id);

    void updateUser( User user);

    void deleteUser(Long id);

}
