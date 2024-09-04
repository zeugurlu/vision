package com.example.vision.controller.usersController;


import com.example.vision.entity.Users;
import com.example.vision.service.users.IUsersService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


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
}
