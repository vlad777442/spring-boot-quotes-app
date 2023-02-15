package com.kameleoon.quotesmanager.service;

import com.kameleoon.quotesmanager.dto.QuoteRequestDTO;
import com.kameleoon.quotesmanager.dto.QuoteResponseDTO;
import com.kameleoon.quotesmanager.mapper.QuoteMapper;
import com.kameleoon.quotesmanager.model.Quote;
import com.kameleoon.quotesmanager.model.User;
import com.kameleoon.quotesmanager.repository.QuoteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService{
    private final static Random RANDOMIZER = new Random();
    @Autowired
    QuoteRepository quoteRepository;
    @Autowired
    UserService userService;

    @Autowired
    private QuoteMapper quoteMapper;

    @Override
    public QuoteRequestDTO createQuote(Long userId, QuoteRequestDTO quote) {
        User user = userService.getUserById(userId);
        Quote new_quote = quoteMapper.toQuote(quote);
        new_quote.setCreatedAt(LocalDateTime.now());
        new_quote.setUser(user);
        new_quote.setRating(0);

        return quoteMapper.toQuoteRequestDTO(quoteRepository.save(new_quote));
    }

    @Override
    public List<QuoteResponseDTO> getAllQuotes() {
        return quoteMapper.toQuoteResponseDTOList(quoteRepository.findAll());
    }

    @Override
    public QuoteResponseDTO getRandomQuote() {
        return quoteMapper.toQuoteResponseDTO(getQuoteById(nextLong(1, quoteRepository.count() + 1)));
    }

    @Override
    public Quote getQuoteById(Long id) {
        try {
            Quote quote = quoteRepository.findById(id).get();
            return (quote);
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException(String.format("Quote is not found", id));
        }

    }

    @Override
    public QuoteResponseDTO getQuoteResponseDTOById(Long id) {
        return quoteMapper.toQuoteResponseDTO(getQuoteById(id));
    }

    @Override
    public QuoteRequestDTO updateQuote(Long userId, Long quoteId, QuoteRequestDTO quote) {
        User user = userService.getUserById(userId);
        Quote new_quote = getQuoteById(quoteId);
        if (user.equals(new_quote.getUser())) {
            new_quote.setContent(quote.getContent());
            quoteRepository.save(new_quote);
            return quoteMapper.toQuoteRequestDTO(new_quote);
        } else {
            throw new ValidationException("Wrong user");
        }

    }

    @Override
    public void deleteQuoteById(Long id) {
        quoteRepository.deleteById(id);
    }

    @Override
    public List<QuoteResponseDTO> getTop10() {
        List<Quote> topQuotes = quoteRepository.findTopQuotes();
        if (topQuotes.size() > 10) {
            topQuotes = topQuotes.subList(0, 10);
        }
        return quoteMapper.toQuoteResponseDTOList(topQuotes);
    }

    @Override
    public List<QuoteResponseDTO> getFlop10() {
        List<Quote> worstQuotes = quoteRepository.findWorstQuotes();
        if (worstQuotes.size() > 10) {
            worstQuotes = worstQuotes.subList(0, 10);
        }
        return quoteMapper.toQuoteResponseDTOList(worstQuotes);
    }



    private long nextLong(long lowerRange, long upperRange) {
        return (long)(RANDOMIZER.nextDouble() * (upperRange - lowerRange)) + lowerRange;
    }


}
