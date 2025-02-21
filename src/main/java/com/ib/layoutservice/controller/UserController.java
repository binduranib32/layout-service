package com.ib.layoutservice.controller;

import com.ib.layoutservice.entity.Layout;
import com.ib.layoutservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
//@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //explicitly define a constructor since @RequiredArgsConstructor not working
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/{userId}/assign/{layoutId}")
    public ResponseEntity<String> assignLayout(@PathVariable Long userId, @PathVariable Long layoutId) {
        userService.assignLayout(userId, layoutId);
        return ResponseEntity.ok("Layout assigned successfully");
    }

    @PutMapping("/{userId}/update/{layoutId}")
    public ResponseEntity<String> updateUserLayout(@PathVariable Long userId, @PathVariable Long layoutId) {
        userService.updateUserLayout(userId, layoutId);
        return ResponseEntity.ok("User layout updated successfully");
    }

    @GetMapping("/{userId}/layout")
    public ResponseEntity<Layout> getUserLayout(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserLayout(userId));
    }
}
