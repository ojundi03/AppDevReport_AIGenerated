//package com.petso1.petso1.controllers;
//
//import com.petso1.petso1.entities.User;
//import com.petso1.petso1.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//
//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    // Create a new user
//    @Secured("ROLE_ADMIN")
//    @PostMapping
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        User createdUser = userService.createUser(user);
//        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
//    }
//
//    // Reset password
//    @Secured("ROLE_ADMIN")
//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
//        User updatedUser = userService.updateUser(id, userDetails);
//        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//    }
//
//    // Toggle unlocked status
//    @Secured("ROLE_ADMIN")
//    @PutMapping("/{id}/toggle-unlocked")
//    @ResponseStatus(HttpStatus.OK)
//    public void toggleUnlockedStatus(@PathVariable Long id) {
//        userService.toggleUnlockedStatus(id);
//    }
//
//    // Delete user
//    @Secured("ROLE_ADMIN")
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//    }
//}
