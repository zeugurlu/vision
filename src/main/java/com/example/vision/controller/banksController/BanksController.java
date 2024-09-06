package com.example.vision.controller.banksController;

import com.example.vision.entity.Banks;
import com.example.vision.service.banks.IBanksService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/banks")
@RequiredArgsConstructor
public class BanksController {
    private static final Logger logger = LoggerFactory.getLogger(BanksController.class);
    private final IBanksService iBanksService;

    @PostMapping
    public Banks add(@RequestBody Banks banks) {
        try {
            logger.info("inside BanksController.post() worked.");
            return this.iBanksService.post(banks);
        } catch (Exception e) {
            logger.error("Error", e );
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.toString());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Banks> getById(@PathVariable Integer id) {
        try {
            logger.info("Inside BanksController.getById() for bankId: {}", id);
            Banks bank = this.iBanksService.getById(id);
            return ResponseEntity.ok(bank);
        } catch (IllegalArgumentException e) {
            logger.error("Bank not found for id: {}", id, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Banks>> getAll() {
        try {
            List<Banks> banks = this.iBanksService.getAll();
            return ResponseEntity.ok(banks);
        } catch (Exception e) {
            logger.error("Error fetching all banks", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Banks> update(@PathVariable Integer id, @RequestBody Banks banks) {
        try {
            logger.info("Inside BanksController.update() for bankId: {}", id);
            Banks updatedBank = this.iBanksService.update(id, banks);
            return ResponseEntity.ok(updatedBank);
        } catch (IllegalArgumentException e) {
            logger.error("Bank not found for id: {}", id, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            logger.info("Inside BanksController.delete() for bankId: {}", id);
            this.iBanksService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            logger.error("Bank not found for id: {}", id, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/email")
    public List<Banks> getBanksByEmail(@RequestBody String user_email) {
        System.out.println("Received email: " + user_email);
        return this.iBanksService.findBanksByEmail(user_email);
    }




}
