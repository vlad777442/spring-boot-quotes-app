package com.kameleoon.quotesmanager.service;

import com.kameleoon.quotesmanager.model.Quote;
import com.kameleoon.quotesmanager.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public interface QuoteService {

    Quote createQuote(Quote quote);

    List<Quote> getAllQuotes();

    Quote getRandomQuote();
    Quote getQuoteById(Long id);

    Quote updateQuote(Quote quote);

    void deleteQuoteById(Long id);

    List<Quote> getTop10();
//    Select Count(*), Topic,isLike FROM LikesDislikes GROUP BY Topic,isLike
//SELECT topic FROM likesdislikes WHERE userName = 'user' AND isLike = true;
}
