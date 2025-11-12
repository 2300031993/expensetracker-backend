package com.KLU.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.KLU.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
