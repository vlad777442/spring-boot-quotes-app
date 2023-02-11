package com.kameleoon.quotesmanager.repository;

import com.kameleoon.quotesmanager.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
