package com.KLU.controller;

import com.KLU.model.SavedTransaction;
import com.KLU.model.Transaction;
import com.KLU.service.SavedTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/savedTransactions")
@CrossOrigin(origins = "http://localhost:3000")
public class SavedTransactionController {

    @Autowired
    private SavedTransactionService savedTransactionService;

    @GetMapping
    public List<SavedTransaction> getSavedTransactions(@RequestParam String email) {
        return savedTransactionService.getSavedTransactionsByUser(email);
    }

    @PostMapping
    public SavedTransaction addSavedTransaction(@RequestBody SavedTransaction transaction) {
        return savedTransactionService.saveTransaction(transaction);
    }

    @PutMapping("/{id}")
    public SavedTransaction updateSavedTransaction(@PathVariable Long id, @RequestBody SavedTransaction transaction) {
        return savedTransactionService.updateTransaction(id, transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteSavedTransaction(@PathVariable Long id) {
        savedTransactionService.deleteTransaction(id);
    }

    // ✅ Confirm & add to real transaction table
    @PostMapping("/confirm/{id}")
    public Transaction confirmSavedTransaction(@PathVariable Long id) {
        return savedTransactionService.confirmTransaction(id);
    }
}
