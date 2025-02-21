package com.ib.layoutservice.service;

import com.ib.layoutservice.entity.Layout;
import com.ib.layoutservice.entity.User;
import com.ib.layoutservice.repository.LayoutRepository;
import com.ib.layoutservice.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final LayoutRepository layoutRepository;

    //explicitly define a constructor since @RequiredArgsConstructor not working
    public UserService(UserRepository userRepository, LayoutRepository layoutRepository) {
        this.userRepository = userRepository;
        this.layoutRepository = layoutRepository;
    }

    @Transactional
    public void assignLayout(Long userId, Long layoutId, String name) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Layout layout = layoutRepository.findById(layoutId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Layout not found"));

        user.setLayout(layout);  // Fix missing method error
        userRepository.save(user);
    }

    @Transactional
    public void updateUserLayout(Long userId, Long layoutId, String layoutame) {
        assignLayout(userId, layoutId, layoutame);
    }

    public Layout getUserLayout(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        return Optional.ofNullable(user.getLayout())  // Fix missing method error
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User has no layout assigned"));
    }
}
