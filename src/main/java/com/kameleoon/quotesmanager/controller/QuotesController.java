package com.kameleoon.quotesmanager.controller;

import com.kameleoon.quotesmanager.model.Quote;
import com.kameleoon.quotesmanager.repository.QuoteRepository;
import com.kameleoon.quotesmanager.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotes")
public class QuotesController {
    @Autowired
    QuoteService quoteService;

    @GetMapping("/random")
    public Quote getRandomQuote() {
        return quoteService.getRandomQuote();
    }

    @GetMapping("/{id}")
    public Quote getQuote(@PathVariable Long id) {
        return quoteService.getQuoteById(id);
    }
    @GetMapping("/")
    public List<Quote> getAllQuotes() {
        return quoteService.getAllQuotes();
    }

    @PostMapping("/")
    public Quote createQuote(@RequestBody Quote quote) {
        return quoteService.createQuote(quote);
    }

    @PutMapping("/{id}")
    public Quote updateQuote(@RequestBody Quote quote, @PathVariable Long id) {
//        quote.setId(id);
        return quoteService.updateQuote(quote);
    }

    @DeleteMapping("/{id}")
    public void deleteQuote(@PathVariable Long id) {
        quoteService.deleteQuote(id);

    }


    @GetMapping("/top10")
    public List<Quote> getTop10() {
        return quoteService.getTop10();
    }


}
