package com.kameleoon.quotesmanager.service;

import com.kameleoon.quotesmanager.model.Quote;
import com.kameleoon.quotesmanager.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteService {
    private final static Random RANDOMIZER = new Random();
    @Autowired
    QuoteRepository quoteRepository;

    public Quote createQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    public Quote getRandomQuote() {
        return getQuoteById(nextLong(1, quoteRepository.count() + 1));
    }
    public Quote getQuoteById(Long id) {
        return quoteRepository.getReferenceById(id);
    }

    public Quote updateQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    public void deleteQuote(Long id) {
        quoteRepository.deleteById(id);
    }

    private long nextLong(long lowerRange, long upperRange) {
        return (long)(RANDOMIZER.nextDouble() * (upperRange - lowerRange)) + lowerRange;
    }
}
