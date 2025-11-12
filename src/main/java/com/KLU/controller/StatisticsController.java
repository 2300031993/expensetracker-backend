package com.KLU.controller;

import com.KLU.model.Transaction;
import com.KLU.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/statistics")
@CrossOrigin(origins = "http://localhost:3000")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    // ✅ Total income, expense, and other insights for one user
    @GetMapping
    public Map<String, Object> getStatistics(@RequestParam String email) {
        return statisticsService.getStatistics(email);
    }
}
