package com.kameleoon.quotesmanager.service;

import com.kameleoon.quotesmanager.model.Vote;



public interface VoteService {

    Vote castVote(Long userId, Long quoteId, String value);

//    long countUserIdAndQuoteId(Long quoteId, Long userId);
    Vote findByQuoteAndUserId(Long quoteId, Long userId);
}
