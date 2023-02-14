package com.kameleoon.quotesmanager.service;

import com.kameleoon.quotesmanager.model.Quote;
import com.kameleoon.quotesmanager.model.User;
import com.kameleoon.quotesmanager.model.Vote;
import org.springframework.stereotype.Service;

@Service
public interface VoteService {

    Vote castVote(Long quoteId, Long userId, int value);

//    long countUserIdAndQuoteId(Long quoteId, Long userId);
    Vote findByQuoteAndUserId(Long quoteId, Long userId);
}
