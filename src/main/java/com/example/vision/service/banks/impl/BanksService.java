package com.example.vision.service.banks.impl;

import com.example.vision.entity.Banks;
import com.example.vision.repository.IBanks;
import com.example.vision.service.banks.IBanksService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BanksService implements IBanksService {
    private static final Logger logger = LoggerFactory.getLogger(BanksService.class);
    private final IBanks banks;

    @Override
    public Banks post(Banks banks) {
        logger.info("BanksService post() function successfully worked.");
        return this.banks.save(banks);
    }

    @Override
    public Banks getById(Integer id) {
        return this.banks.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Bank with id " + id + " not found."));
    }

    @Override
    public List<Banks> getAll() {
        return this.banks.findAll();
    }

    @Override
    public Banks update(Integer id, Banks banks) {
        if (!this.banks.existsById(id)) {
            throw new IllegalArgumentException("Bank with id " + id + " not found.");
        }
        banks.setId(id);
        return this.banks.save(banks);
    }

    @Override
    public void delete(Integer id) {
        if (!this.banks.existsById(id)) {
            throw new IllegalArgumentException("Bank with id " + id + " not found.");
        }
        this.banks.deleteById(id);
    }


    @Override
    public List<Banks> findBanksByEmail(String user_email) {
        return this.banks.findBanksByEmail(user_email);
    }

    @Override
    public Long totalCredits(String user_email) {
        return this.banks.totalCredits(user_email);
    }

    @Override
    public List<Banks> findBanksByBankCode(String bank_code) {
        return this.banks.findBanksByBankCode(bank_code);
    }


}
