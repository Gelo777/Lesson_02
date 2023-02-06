package com;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable(value = "id") Integer id) {
        return userService.findById(id);
    }

    @PutMapping("/user")
    public void add(@RequestBody User user){
        userService.add(user);
    }
    @DeleteMapping("/user/{id}")
    public User delete(@PathVariable(value = "id") Integer id) {
        return userService.delete(id);
    }

    @PostMapping("/user")
    public void update(@RequestBody User user){
        userService.update(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}


