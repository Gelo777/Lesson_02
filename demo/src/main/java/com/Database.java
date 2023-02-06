package com;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Database {

    private Map<Integer, User> users = new HashMap<>();
    public User getUserById(Connection connection, Integer id) {
        if (connectionValid(connection)) {
            return users.get(id);
        } else {
            throw new RuntimeException("Не удалось установить соеденение с бд");
        }
    }

    public User getUserByName(Connection connection, String name) {
        if (connectionValid(connection)) {
            for (User user : users.values()) {
                if (user.getName().equals(name)) {
                    return user;
                }
            }
        } else {
            throw new RuntimeException("Не удалось установить соеденение с бд");
        }
        return null;
    }


    public boolean connectionValid(Connection connection) {
        String address = "localhost";
        String password = "1234";
        String username = "admin";
        return username.equals(connection.getUsername()) &&
                password.equals(connection.getPassword()) &&
                address.equals(connection.getAddress());
    }

    public User delete(Integer id) {
        return users.remove(id);
    }

    public void update(User user) {
        users.put(user.getId(), user);
    }

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public List<User> getAllUsers(){
        return users.values().stream().toList();
    }
}



