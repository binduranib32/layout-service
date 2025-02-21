package com.ib.layoutservice.controller;

import com.ib.layoutservice.entity.Layout;
import com.ib.layoutservice.entity.User;
import com.ib.layoutservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/{userId}/assign/{layoutId}")
    public ResponseEntity<String> assignLayout(@PathVariable Long userId, @PathVariable Long layoutId, @PathVariable String name) {
        userService.assignLayout(userId, layoutId, name);
        return ResponseEntity.ok("Layout assigned successfully");
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok("User Created successfully");
    }


    @GetMapping("/{userId}/layout")
    public ResponseEntity<Layout> getUserLayout(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserLayout(userId));
    }
}
