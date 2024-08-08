package com.vitalysukhinin.financial_system.services;

import com.vitalysukhinin.financial_system.dto.CustomPage;
import com.vitalysukhinin.financial_system.dto.TransactionGroupResponse;
import com.vitalysukhinin.financial_system.dto.TransactionResponse;
import com.vitalysukhinin.financial_system.dto.UserSimple;
import com.vitalysukhinin.financial_system.entities.Label;
import com.vitalysukhinin.financial_system.entities.Transaction;
import com.vitalysukhinin.financial_system.entities.TransactionGroup;
import com.vitalysukhinin.financial_system.entities.User;
import com.vitalysukhinin.financial_system.repositories.LabelRepository;
import com.vitalysukhinin.financial_system.repositories.TransactionGroupRepository;
import com.vitalysukhinin.financial_system.repositories.TransactionRepository;
import com.vitalysukhinin.financial_system.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

@Service
@Transactional
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final LabelRepository labelRepository;
    private final TransactionGroupRepository transactionGroupRepository;
    private final PdfGenerationService pdfGenerationService;

    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository, LabelRepository labelRepository, TransactionGroupRepository transactionGroupRepository, PdfGenerationService pdfGenerationService) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.labelRepository = labelRepository;
        this.transactionGroupRepository = transactionGroupRepository;
        this.pdfGenerationService = pdfGenerationService;
    }

    public Optional<Transaction> addTransaction(Transaction transaction) {
        Optional<Transaction> result = Optional.empty();
        Optional<User> optionalUser = userRepository.findByEmail(transaction.getUser().getEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            transaction.setUser(user);
            transaction.getTransactionGroup().setUser(user);
            transaction.setCreatedAt(LocalDateTime.now());
            transaction.setHashcode(
                    String.valueOf(Objects.hash(transaction.getUser(),
                            transaction.getTransactionDate(),
                            transaction.getCreatedAt(),
                            transaction.getAmount(),
                            transaction.getDescription(),
                            transaction.getLabel()))
            );
            Transaction savedTransaction = transactionRepository.save(transaction);
            result = Optional.of(savedTransaction);
        }
        return result;
    }

    public void deleteTransaction(Integer id) {
        transactionRepository.deleteById(id);
    }

    public Optional<Transaction> updateTransaction(Transaction transaction) {
        Optional<Transaction> result = Optional.empty();
        Optional<User> optionalUser = userRepository.findByEmail(transaction.getUser().getEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            transaction.setUser(user);
            transaction.getTransactionGroup().setUser(user);
            Transaction savedTransaction = transactionRepository.save(transaction);
            result = Optional.of(savedTransaction);
        }
        return result;
    }

    public CustomPage<TransactionResponse> getTransactions(String email, LocalDateTime from, LocalDateTime to, String labelName, Integer type, String groupName, Boolean all, Pageable pageable) {
        User user = userRepository.findByEmail(email).orElse(null);
        TransactionGroup group = transactionGroupRepository.findByNameAndUser(groupName, user).orElse(null);
        Label label = labelRepository.findByName(labelName).orElse(null);
        Specification<Transaction> specification = TransactionSearchFilter.filters(user, from, to, label, type, group);
        CustomPage<TransactionResponse> response = new CustomPage<>();
        List<TransactionResponse> content;
        boolean getAll = all == null ? false : all.booleanValue();
        if (getAll) {
            List<Transaction> transactions = transactionRepository.findAll(specification);
            content = transactions.stream().map(convert()).toList();
            response.setTotalElements(transactions.size());
        } else {
            Page<Transaction> transactions = transactionRepository.findAll(specification, pageable);
            content = transactions.map(convert()).stream().toList();
            response.setPageNumber(transactions.getNumber());
            response.setPageSize(transactions.getSize());
            response.setTotalElements(transactions.getTotalElements());
            response.setTotalPages(transactions.getTotalPages());
        }
        response.setContent(content);
        return response;
    }

    private Function<Transaction, TransactionResponse> convert() {
        return transaction -> new TransactionResponse(
                new UserSimple(transaction.getUser().getUsername()),
                transaction.getHashcode(),
                new TransactionGroupResponse(
                        transaction.getTransactionGroup().getId(),
                        transaction.getTransactionGroup().getName(),
                        transaction.getTransactionGroup().getTransactionType(),
                        new UserSimple(transaction.getUser().getUsername())
                ),
                transaction.getLabel(),
                transaction.getTransactionDate(),
                transaction.getAmount(),
                transaction.getDescription(),
                transaction.getBalance()
        );
    }

    public List<Transaction> getTransactions(User user, LocalDateTime from, LocalDateTime to, String labelName, Integer type, String groupName) {
        TransactionGroup group = transactionGroupRepository.findByNameAndUser(groupName, user).orElse(null);
        Label label = labelRepository.findByName(labelName).orElse(null);

        Specification<Transaction> specification = TransactionSearchFilter.filters(user, from, to, label, type, group);
        List<Transaction> transactions = transactionRepository.findAll(specification);
        return transactions;
    }

    public byte[] generateUserTransactionPdf(String email, LocalDateTime from, LocalDateTime to, String label, Integer type, String group) {
        User user = userRepository.findByEmail(email).orElse(null);
        List<Transaction> transactions = getTransactions(user, from, to, label, type, group);

        return pdfGenerationService.generateUserTransactionPdf(user, transactions);
    }
}