package com.KLU.service;

import com.KLU.model.Transaction;
import com.KLU.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StatisticsService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Map<String, Object> getStatistics(String email) {
        List<Transaction> transactions = transactionRepository.findByUserEmail(email);

        double totalIncome = transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("income"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        double totalExpense = transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("expense"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        // ✅ Expense by category
        Map<String, Double> expenseByCategory = transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("expense"))
                .collect(Collectors.groupingBy(
                        Transaction::getCategory,
                        Collectors.summingDouble(Transaction::getAmount)
                ));

        // ✅ Monthly Income vs Expense
        Map<String, Map<String, Double>> monthlyData = new LinkedHashMap<>();
        for (Transaction t : transactions) {
            if (t.getDate() == null) continue;
            String month = t.getDate().getMonth().name().substring(0, 3); // e.g., "JAN"
            monthlyData.putIfAbsent(month, new HashMap<>());
            Map<String, Double> monthMap = monthlyData.get(month);
            monthMap.put(t.getType().toLowerCase(),
                    monthMap.getOrDefault(t.getType().toLowerCase(), 0.0) + t.getAmount());
        }

        Map<String, Object> stats = new HashMap<>();
        stats.put("totalIncome", totalIncome);
        stats.put("totalExpense", totalExpense);
        stats.put("expenseByCategory", expenseByCategory);
        stats.put("monthlyData", monthlyData);

        return stats;
    }
}
