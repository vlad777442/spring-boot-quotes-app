package com.kameleoon.quotesmanager.service;

import com.kameleoon.quotesmanager.exception.AlreadyVotedException;
import com.kameleoon.quotesmanager.model.Quote;
import com.kameleoon.quotesmanager.model.User;
import com.kameleoon.quotesmanager.model.Vote;
import com.kameleoon.quotesmanager.repository.QuoteRepository;
import com.kameleoon.quotesmanager.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    VoteRepository voteRepository;

    @Autowired
    QuoteService quoteService;


    @Override
    public Vote castVote(Long quoteId, Long userId, int value) {
        Vote vote = findByQuoteAndUserId(quoteId, userId);
        Quote quote = quoteService.getQuoteById(quoteId);

        if (vote.getValue() == value) {
            throw new AlreadyVotedException("User has already voted on this quote");
        }
        else if (vote == null || vote.getValue() != value) {
            quote.setRating(quote.getRating() + value);
            quoteService.updateQuote(quote);

            vote.setValue(value);
            voteRepository.save(vote);
        }
        return vote;

    }


    @Override
    public Vote findByQuoteAndUserId(Long quoteId, Long userId) {
        return voteRepository.findByQuoteAndUserId(quoteId, userId);
    }

//    @Override
//    public long countUserIdAndQuoteId(Long quoteId, Long userId) {
//        return voteRepository.countByUserIdAndQuoteId(quoteId, userId);
//    }

//    public Vote saveOrUpdateVote(Long postId, Long userId, Integer rating) {
//        List<Vote> existingRating = voteRepository.findByPostIdAndUserId(postId, userId);
//        if (existingRating.isPresent()) {
//            existingRating.get().setRating(rating);
//            return ratingRepository.save(existingRating.get());
//        } else {
//            Rating newRating = new Rating();
//            newRating.setPostId(postId);
//            newRating.setUserId(userId);
//            newRating.setRating(rating);
//            return ratingRepository.save(newRating);
//        }
//    }

}
