package com.KLU.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "saved_transactions")
public class SavedTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;       // e.g., Rent, Electricity Bill
    private String category;    // e.g., Household, Food
    private Double amount;
    private String type;        // "income" or "expense"
    private String frequency;   // "DAILY", "MONTHLY", "ONE_TIME"
    private LocalDate dueDate;
    private String description;
    private String userEmail;

    public SavedTransaction() {}

    // ✅ Constructor
    public SavedTransaction(String title, String category, Double amount, String type,
                            String frequency, LocalDate dueDate, String description, String userEmail) {
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.type = type;
        this.frequency = frequency;
        this.dueDate = dueDate;
        this.description = description;
        this.userEmail = userEmail;
    }

    // ✅ Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getFrequency() { return frequency; }
    public void setFrequency(String frequency) { this.frequency = frequency; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
}
