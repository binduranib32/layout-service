package com.ib.layoutservice.service;

import com.ib.layoutservice.entity.Layout;
import com.ib.layoutservice.entity.User;
import com.ib.layoutservice.repository.LayoutRepository;
import com.ib.layoutservice.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final LayoutRepository layoutRepository;

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

        user.setLayout(layout);
        userRepository.save(user);
    }

   public User createUser(User user){

        User user1 = new User();
        user1.setEmail(user.getEmail());
        user1.setUsername(user.getUsername());
        userRepository.save(user);
        return user1;

   }

    public Layout getUserLayout(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        return Optional.ofNullable(user.getLayout())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User has no layout assigned"));
    }
}
