package org.example.service;

import org.example.model.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    List<User> userList = new ArrayList<>();

    public void addUser(User user) {
        userList.add(user);
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public int userCount() {
        return userList.size();
    }

    public double getUsersAverageAge() {
        return userList.stream()
                .mapToInt(User::age)
                .average()
                .orElse(0);
    }
}
