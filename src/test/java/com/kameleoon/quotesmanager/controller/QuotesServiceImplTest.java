package com.kameleoon.quotesmanager.controller;

import com.kameleoon.quotesmanager.dto.QuoteRequestDTO;
import com.kameleoon.quotesmanager.dto.QuoteResponseDTO;
import com.kameleoon.quotesmanager.dto.UserRequestDTO;
import com.kameleoon.quotesmanager.mapper.QuoteMapper;
import com.kameleoon.quotesmanager.model.Quote;
import com.kameleoon.quotesmanager.model.VoteType;
import com.kameleoon.quotesmanager.service.QuoteService;
import com.kameleoon.quotesmanager.service.UserService;
import com.kameleoon.quotesmanager.service.VoteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.kameleoon.quotesmanager.controller.TestData.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
@Transactional
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class QuotesServiceImplTest {
    @Autowired
    private QuoteService quoteService;
    @Autowired
    private UserService userService;
    @Autowired
    private VoteService voteService;
    @Autowired
    private QuoteMapper quoteMapper;

    @BeforeAll
    void setUp() {
        userService.createUser(user1);
        userService.createUser(user2);
        userService.createUser(user3);

        quoteService.createQuote(1L, quote1);
        quoteService.createQuote(2L, quote2);
        quoteService.createQuote(3L, quote3);
    }

    @Test
    void getRandomQuote() {
        QuoteResponseDTO quoteResponseDTO = quoteService.getRandomQuote();
        assertThat(quoteResponseDTO, is(notNullValue()));
    }

    @Test
    void getQuote() {
        Quote quote = quoteService.getQuoteById(1L);
        assertThat(quote.getContent(), equalTo("This is 1 quote of the day"));
        assertThat(quote.getRating(), equalTo(0));
        assertThat(quote.getUser().getId(), equalTo(1L));
    }

    @Test
    void getAllQuotes() {
        List<QuoteResponseDTO> quoteResponseDTOList = quoteService.getAllQuotes();
        for (int i = 0; i < quoteResponseDTOList.size(); i++)
            System.out.println(quoteResponseDTOList.get(i).toString());
        assertThat(quoteResponseDTOList.size(), equalTo(3));
    }

    @Test
    void createQuote() {
        QuoteRequestDTO quoteRequestDTO = new QuoteRequestDTO("Content");
        quoteService.createQuote(1L, quoteRequestDTO);

        QuoteResponseDTO quoteResponseDTO = quoteService.getQuoteResponseDTOById(4L);
        System.out.println(quoteResponseDTO.getId());
        System.out.println(quoteResponseDTO.getContent());
        assertThat(quoteResponseDTO.getContent(), equalTo("Content"));
    }

    @Test
    void updateQuote() {
        Quote quote1 = quoteService.getQuoteById(1L);
        quote1.setContent("This is updated content");
        quoteService.updateQuote(1L, 1L, quoteMapper.toQuoteRequestDTO(quote1));
        Quote quote = quoteService.getQuoteById(1L);
        assertThat(quote.getContent(), equalTo("This is updated content"));
    }


    @Test
    void voteQuote() {
        voteService.castVote(1L, 2L, VoteType.UP.toString());
        Quote quote = quoteService.getQuoteById(2L);
        assertThat(quote.getRating(), equalTo(1));
    }


}