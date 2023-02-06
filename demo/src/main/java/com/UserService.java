package com;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private Connection connection;
    private Database database;

    public UserService(Connection connection, Database database) {
        this.connection = connection;
        this.database = database;
    }

    public User findById(Integer id){
        return database.getUserById(connection,id);
    }

    public User findByName(String name){
        return database.getUserByName(connection, name);
    }

    public void add(User user){
        database.save(user);
    }

    public void update(User user){
        database.update(user);
    }

    public User delete(Integer id){
        return database.delete(id);
    }

    public List<User> getAllUsers(){
        return database.getAllUsers();
    }
}




