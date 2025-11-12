package com.KLU.repository;

import com.KLU.model.SavedTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavedTransactionRepository extends JpaRepository<SavedTransaction, Long> {
    List<SavedTransaction> findByUserEmail(String email);
}
