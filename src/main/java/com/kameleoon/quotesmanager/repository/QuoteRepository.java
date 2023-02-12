package com.kameleoon.quotesmanager.repository;

import com.kameleoon.quotesmanager.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long>  {
    @Query("Select Count(*), Topic,isUpVote FROM Vote GROUP BY quote, isUpVote")
    List<Quote> findTopTenQuotes();
}
