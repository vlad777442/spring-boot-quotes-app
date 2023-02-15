package com.kameleoon.quotesmanager.service;

import com.kameleoon.quotesmanager.dto.QuoteRequestDTO;
import com.kameleoon.quotesmanager.dto.QuoteResponseDTO;
import com.kameleoon.quotesmanager.model.Quote;


import java.util.List;



public interface QuoteService {

    QuoteRequestDTO createQuote(Long userId, QuoteRequestDTO quote);


    List<QuoteResponseDTO> getAllQuotes();

    QuoteResponseDTO getRandomQuote();
    Quote getQuoteById(Long id);

    QuoteResponseDTO getQuoteResponseDTOById(Long id);

    QuoteRequestDTO updateQuote(Long userId, Long quoteId, QuoteRequestDTO quote);



    void deleteQuoteById(Long id);

    List<QuoteResponseDTO> getTop10();

    List<QuoteResponseDTO> getFlop10();



}
