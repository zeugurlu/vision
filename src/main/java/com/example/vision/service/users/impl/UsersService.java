package com.example.vision.service.users.impl;

import com.example.vision.entity.Users;
import com.example.vision.repository.IUsers;
import com.example.vision.service.users.IUsersService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService implements IUsersService {
    private static final Logger logger = LoggerFactory.getLogger(UsersService.class);
    private final IUsers users;


    @Override
    public Users post(Users users) {
        logger.info("UsersService post() function successfully worked.");
        return this.users.save(users);
    }

}
