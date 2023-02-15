package com.kameleoon.quotesmanager.controller;

import com.kameleoon.quotesmanager.dto.QuoteRequestDTO;
import com.kameleoon.quotesmanager.dto.QuoteResponseDTO;
import com.kameleoon.quotesmanager.mapper.QuoteMapper;
import com.kameleoon.quotesmanager.model.Quote;
import com.kameleoon.quotesmanager.model.VoteType;
import com.kameleoon.quotesmanager.repository.QuoteRepository;
import com.kameleoon.quotesmanager.service.QuoteService;
import com.kameleoon.quotesmanager.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/quotes")
public class QuotesController {
    @Autowired
    QuoteService quoteService;
    @Autowired
    VoteService voteService;

    QuoteMapper quoteMapper;

    @GetMapping("/random")
    public QuoteResponseDTO getRandomQuote() {
        return quoteService.getRandomQuote();
    }

    @GetMapping("/{id}")
    public QuoteResponseDTO getQuote(@PathVariable Long id) {
        return quoteMapper.toQuoteResponseDTO(quoteService.getQuoteById(id));
    }
    @GetMapping("/")
    public List<QuoteResponseDTO> getAllQuotes() {
        return quoteService.getAllQuotes();
    }

    @PostMapping("/")
    public QuoteRequestDTO createQuote(@PathVariable Long userId, @RequestBody QuoteRequestDTO quote) {
        return quoteService.createQuote(userId, quote);
    }

    @PutMapping("/{id}")
    public QuoteRequestDTO updateQuote(@PathVariable Long userId, @PathVariable Long id, @RequestBody QuoteRequestDTO quote) {
        return quoteService.updateQuote(userId, id, quote);
    }

    @DeleteMapping("/{id}")
    public void deleteQuote(@PathVariable Long id) {
        quoteService.deleteQuoteById(id);

    }

    @PostMapping("/{id}/{voteType}")
    public QuoteResponseDTO voteQuote(@PathVariable Long userId, @PathVariable Long id,
                                    @PathVariable String voteType) {
        voteService.castVote(userId, id, voteType);
        return quoteMapper.toQuoteResponseDTO(quoteService.getQuoteById(id));
    }



    @GetMapping("/top10")
    public List<QuoteResponseDTO> getTop10() {
        return quoteService.getTop10();
    }

    @GetMapping("/flop10")
    public List<QuoteResponseDTO> getFlop10() {
        return quoteService.getFlop10();
    }

}
