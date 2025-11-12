package com.KLU.service;

import com.KLU.model.Transaction;
import com.KLU.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // ✅ Get all transactions for a user
    public List<Transaction> getTransactionsByUser(String userEmail) {
        return transactionRepository.findByUserEmail(userEmail);
    }

    // ✅ Save a new transaction
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // ✅ Update a transaction
    public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
        return transactionRepository.findById(id).map(transaction -> {
            transaction.setTitle(updatedTransaction.getTitle());
            transaction.setAmount(updatedTransaction.getAmount());
            transaction.setCategory(updatedTransaction.getCategory());
            transaction.setType(updatedTransaction.getType());
            transaction.setDate(updatedTransaction.getDate());
            return transactionRepository.save(transaction);
        }).orElseThrow(() -> new RuntimeException("Transaction not found with ID: " + id));
    }

    // ✅ Delete a transaction
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
