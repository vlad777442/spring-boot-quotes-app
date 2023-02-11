package com.kameleoon.quotesmanager.repository;

import com.kameleoon.quotesmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
