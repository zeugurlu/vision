package com.example.vision.controller.banksController;

import com.example.vision.entity.Banks;
import com.example.vision.service.banks.IBanksService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/banks")
@RequiredArgsConstructor
public class BanksController {
    private static final Logger logger = LoggerFactory.getLogger(BanksController.class);
    private final IBanksService iBanksService;

    @PostMapping
    public Banks add(@RequestBody Banks banks) {
        try {
            logger.info("inside UserController.post() worked.");
            return this.iBanksService.post(banks);
        } catch (Exception e) {
            logger.error("Error", e );
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.toString());
        }
    }
}
