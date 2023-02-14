package com.kameleoon.quotesmanager.service;

import com.kameleoon.quotesmanager.model.Quote;
import com.kameleoon.quotesmanager.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService{
    private final static Random RANDOMIZER = new Random();
    @Autowired
    QuoteRepository quoteRepository;

    @Override
    public Quote createQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    @Override
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    @Override
    public Quote getRandomQuote() {
        return getQuoteById(nextLong(1, quoteRepository.count() + 1));
    }

    @Override
    public Quote getQuoteById(Long id) {
        return quoteRepository.getReferenceById(id);
    }

    @Override
    public Quote updateQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    @Override
    public void deleteQuoteById(Long id) {
        quoteRepository.deleteById(id);
    }

    @Override
    public List<Quote> getTop10() {
        List<Quote> topQuotes = quoteRepository.findTopQuotes();
        if (topQuotes.size() > 10) {
            topQuotes = topQuotes.subList(0, 10);
        }
        return topQuotes;
    }

    @Override
    public List<Quote> getFlop10() {
        List<Quote> worstQuotes = quoteRepository.findWorstQuotes();
        if (worstQuotes.size() > 10) {
            worstQuotes = worstQuotes.subList(0, 10);
        }
        return worstQuotes;
    }

    @Override
    public Integer getRating(Long id) {
        return quoteRepository.getReferenceById(id).getRating();
    }

    private long nextLong(long lowerRange, long upperRange) {
        return (long)(RANDOMIZER.nextDouble() * (upperRange - lowerRange)) + lowerRange;
    }

//    public List<Quote> getTop10() {
//
//    }
//    Select Count(*), Topic,isLike FROM LikesDislikes GROUP BY Topic,isLike
//SELECT topic FROM likesdislikes WHERE userName = 'user' AND isLike = true;
}
