package com.example.vision.service.users.impl;

import com.example.vision.entity.Users;
import com.example.vision.repository.IUsers;
import com.example.vision.service.users.IUsersService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Users getById(Integer id) {
        return this.users.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not found."));
    }

    @Override
    public List<Users> getAll() {
        return this.users.findAll();
    }


    @Override
    public Users update(Integer id, Users user) {
        if (!this.users.existsById(id)) {
            throw new IllegalArgumentException("User with id " + id + " not found.");
        }
        user.setId(id);
        return this.users.save(user);
    }

    @Override
    public void delete(Integer id) {
        if (!this.users.existsById(id)) {
            throw new IllegalArgumentException("User with id " + id + " not found.");
        }
        this.users.deleteById(id);
    }

}
