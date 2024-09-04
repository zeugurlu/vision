package com.example.vision.service.banks.impl;

import com.example.vision.entity.Banks;
import com.example.vision.repository.IBanks;
import com.example.vision.service.banks.IBanksService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
}
