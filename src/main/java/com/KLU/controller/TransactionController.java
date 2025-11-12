package com.KLU.controller;

import com.KLU.model.Transaction;
import com.KLU.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // ✅ Fetch transactions only for one user
    @GetMapping
    public List<Transaction> getTransactionsByUser(@RequestParam String email) {
        return transactionService.getTransactionsByUser(email);
    }

    // ✅ Add a new transaction
    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        if (transaction.getUserEmail() == null || transaction.getUserEmail().isEmpty()) {
            throw new RuntimeException("User email is required for adding a transaction.");
        }
        return transactionService.saveTransaction(transaction);
    }

    // ✅ Update a transaction
    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        return transactionService.updateTransaction(id, transaction);
    }

    // ✅ Delete a transaction
    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }
}
