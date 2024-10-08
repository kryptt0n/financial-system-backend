package com.vitalysukhinin.financial_system.controllers;

import com.vitalysukhinin.financial_system.dto.TransactionGroupResponse;
import com.vitalysukhinin.financial_system.dto.UserSimple;
import com.vitalysukhinin.financial_system.entities.TransactionGroup;
import com.vitalysukhinin.financial_system.entities.User;
import com.vitalysukhinin.financial_system.repositories.TransactionGroupRepository;
import com.vitalysukhinin.financial_system.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transaction-groups")
public class TransactionGroupController {

    private final TransactionGroupRepository transactionGroupRepository;
    private final UserRepository userRepository;

    public TransactionGroupController(TransactionGroupRepository transactionGroupRepository, UserRepository userRepository) {
        this.transactionGroupRepository = transactionGroupRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<TransactionGroupResponse>> getAllTransactionGroups(Authentication auth) {
        Optional<User> user = userRepository.findByEmail(auth.getName());
        if (user.isPresent()) {
            List<TransactionGroup> transactionGroups = transactionGroupRepository.findByUserOrUserIsNull(user.get());
            List<TransactionGroupResponse> responses = transactionGroups.stream().map(transactionGroup -> new TransactionGroupResponse(
                    transactionGroup.getId(), transactionGroup.getName(), transactionGroup.getTransactionType(),
                    transactionGroup.getUser() != null ? new UserSimple(transactionGroup.getUser().getEmail()) : null
            )).toList();
            return ResponseEntity.ok(responses);
        }
         else
             return ResponseEntity.notFound().build();
    }

    // TODO: Make all letters in group and label lowercase
    @PostMapping
    public ResponseEntity<String> createTransactionGroup(@RequestBody TransactionGroup transactionGroup) {

        Optional<User> userOptional = userRepository.findByEmail(transactionGroup.getUser().getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            transactionGroup.setUser(user);
            Optional<TransactionGroup> existingGroup = transactionGroupRepository.findByNameAndUserOrNoUser(transactionGroup.getName(), user);
            if (existingGroup.isPresent()) {
                return ResponseEntity.badRequest().body("Transaction group already exists");
            }
            transactionGroupRepository.save(transactionGroup);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body("User does not exist");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTransactionGroup(@PathVariable Integer id) {
        transactionGroupRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<TransactionGroup> updateTransactionGroup(Authentication authentication, @RequestBody TransactionGroup transactionGroup) {
        Optional<User> user = userRepository.findByEmail(authentication.getName());
        if (user.isPresent()) {
            if (transactionGroup.getUser() != null)
                transactionGroup.setUser(user.get());
            TransactionGroup savedTransactionGroup = transactionGroupRepository.save(transactionGroup);
            return ResponseEntity.ok(savedTransactionGroup);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
