package com.kameleoon.quotesmanager.repository;

import com.kameleoon.quotesmanager.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long>  {
    @Query("SELECT q FROM Quote q ORDER BY q.rating DESC")
    List<Quote> findTopQuotes();

    @Query("SELECT q FROM Quote q ORDER BY q.rating ASC")
    List<Quote> findWorstQuotes();

}
