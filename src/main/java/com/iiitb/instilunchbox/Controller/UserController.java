package com.iiitb.instilunchbox.Controller;

import com.iiitb.instilunchbox.Model.User;
import com.iiitb.instilunchbox.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    public User newUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @GetMapping("{email}")
    public User getUser(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }
}
