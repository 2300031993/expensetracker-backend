package com.KLU.service;

import com.KLU.model.SavedTransaction;
import com.KLU.model.Transaction;
import com.KLU.repository.SavedTransactionRepository;
import com.KLU.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavedTransactionService {

    @Autowired
    private SavedTransactionRepository savedTransactionRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public List<SavedTransaction> getSavedTransactionsByUser(String email) {
        return savedTransactionRepository.findByUserEmail(email);
    }

    public SavedTransaction saveTransaction(SavedTransaction transaction) {
        return savedTransactionRepository.save(transaction);
    }

    public SavedTransaction updateTransaction(Long id, SavedTransaction updated) {
        SavedTransaction existing = savedTransactionRepository.findById(id).orElseThrow();
        existing.setTitle(updated.getTitle());
        existing.setCategory(updated.getCategory());
        existing.setAmount(updated.getAmount());
        existing.setType(updated.getType());
        existing.setFrequency(updated.getFrequency());
        existing.setDueDate(updated.getDueDate());
        existing.setDescription(updated.getDescription());
        return savedTransactionRepository.save(existing);
    }

    public void deleteTransaction(Long id) {
        savedTransactionRepository.deleteById(id);
    }

    // ✅ Confirm saved transaction (move to real transaction table)
    public Transaction confirmTransaction(Long id) {
        SavedTransaction saved = savedTransactionRepository.findById(id).orElseThrow();

        Transaction realTransaction = new Transaction();
        realTransaction.setTitle(saved.getTitle());
        realTransaction.setCategory(saved.getCategory());
        realTransaction.setAmount(saved.getAmount());
        realTransaction.setType(saved.getType());
        realTransaction.setDate(saved.getDueDate());
        realTransaction.setUserEmail(saved.getUserEmail());
        realTransaction.setDescription(saved.getDescription());

        transactionRepository.save(realTransaction);

        // Optionally delete after confirming
        savedTransactionRepository.deleteById(id);

        return realTransaction;
    }
}
