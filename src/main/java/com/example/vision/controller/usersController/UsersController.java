package com.example.vision.controller.usersController;


import com.example.vision.entity.Users;
import com.example.vision.service.users.IUsersService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UsersController {
    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
    private final IUsersService iUsersService;

    @PostMapping
    public Users add(@RequestBody Users users) {
        try {
            logger.info("inside UserController.post() worked.");
            return this.iUsersService.post(users);
        } catch (Exception e) {
            logger.error("Error", e );
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.toString());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getById(@PathVariable Integer id){
        try {
            logger.info("Inside UserController.getById() for userId: {}", id);
            Users user = this.iUsersService.getById(id);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            logger.error("User not found for id: {}", id, e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error occurred");
        }
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAll() {
        try {
            List<Users> users = this.iUsersService.getAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error fetching all users", e);
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.toString());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> update(@PathVariable Integer id, @RequestBody Users user) {
        try {
            logger.info("Inside UserController.update() for userId: {}", id);
            Users updatedUser = this.iUsersService.update(id, user);
            return ResponseEntity.ok(updatedUser);
        } catch (IllegalArgumentException e) {
            logger.error("User not found for id: {}", id, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            logger.info("Inside UserController.delete() for userId: {}", id);
            this.iUsersService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            logger.error("User not found for id: {}", id, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
