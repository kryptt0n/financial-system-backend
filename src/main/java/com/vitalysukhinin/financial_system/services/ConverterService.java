package com.vitalysukhinin.financial_system.services;

import com.vitalysukhinin.financial_system.dto.*;
import com.vitalysukhinin.financial_system.entities.RecurringTransaction;
import com.vitalysukhinin.financial_system.entities.Transaction;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ConverterService {

    public Function<Transaction, TransactionResponse> convertTransactionToResponse() {
        return transaction -> new TransactionResponse(
                transaction.getId(),
                new UserSimple(transaction.getUser().getEmail()),
                transaction.getHashcode(),
                transaction.getTransactionGroup() == null ? null :
                        new TransactionGroupResponse(
                                transaction.getTransactionGroup().getId(),
                                transaction.getTransactionGroup().getName(),
                                transaction.getTransactionGroup().getTransactionType(),
                                transaction.getTransactionGroup().getUser() == null ? null :
                                        new UserSimple(transaction.getTransactionGroup().getUser().getEmail())
                        ),
                transaction.getLabel() == null ? null :
                        new LabelResponse(transaction.getLabel().getId(),
                                transaction.getLabel().getName(),
                                transaction.getLabel().getUser() == null ? null :
                                        new UserSimple(transaction.getLabel().getUser().getEmail())),
                transaction.getTransactionDate(),
                transaction.getAmount(),
                transaction.getDescription(),
                transaction.getBalance(),
                transaction.getType()
        );
    }

    public Function<RecurringTransaction, RecurringTransactionResponse> convertRecurringTransactionToResponse() {
        return transaction -> new RecurringTransactionResponse(
                transaction.getId(),
                convertTransactionToResponse().apply(transaction.getTransaction()),
                transaction.getFrequency(),
                transaction.getEndDate()
        );
    }
}
