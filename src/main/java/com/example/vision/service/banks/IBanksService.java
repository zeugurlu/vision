package com.example.vision.service.banks;

import com.example.vision.entity.Banks;

import java.util.List;

public interface IBanksService {
    Banks post(Banks banks);
    Banks getById(Integer id);
    List<Banks> getAll();
    Banks update(Integer id, Banks banks);
    void delete(Integer id);
    List<Banks> findBanksByEmail(String user_email);
}
