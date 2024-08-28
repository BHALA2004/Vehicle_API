package com.vehicleManagement.Vehicle.customerController;


import com.vehicleManagement.Vehicle.customerService.UserService;
import com.vehicleManagement.Vehicle.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor

public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hi User");
    }

//    @PostMapping
//    public User createUser(@RequestBody User user){
//
//        return userService.CreateUser(user);
//
//    }




}
