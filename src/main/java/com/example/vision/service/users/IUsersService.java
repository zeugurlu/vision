package com.example.vision.service.users;

import com.example.vision.entity.Users;

import java.util.List;
import java.util.Optional;

public interface IUsersService {
    Users post(Users users);
    Users getById(Integer id);
    List<Users> getAll();
    Users update(Integer id, Users user);
    void delete(Integer id);

}
