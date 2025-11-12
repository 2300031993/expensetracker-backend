package com.KLU.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;       // e.g., Salary, Rent, Groceries
    private String category;    // e.g., Income, Household, Food
    private Double amount;
    private String type;        // "income" or "expense"
    private LocalDate date;

    // ✅ Newly added fields
    private String userEmail;   // To associate transactions with a logged-in user
    private String description; // Optional details about the transaction

    public Transaction() {}

    // ✅ Constructor
    public Transaction(String title, String category, Double amount, String type,
                       LocalDate date, String userEmail, String description) {
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.userEmail = userEmail;
        this.description = description;
    }

    // ✅ Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
