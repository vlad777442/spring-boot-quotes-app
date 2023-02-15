package com.kameleoon.quotesmanager.service;

import com.kameleoon.quotesmanager.exception.AlreadyVotedException;
import com.kameleoon.quotesmanager.model.Quote;
import com.kameleoon.quotesmanager.model.User;
import com.kameleoon.quotesmanager.model.Vote;
import com.kameleoon.quotesmanager.model.VoteType;
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
    QuoteRepository quoteRepository;

    @Autowired
    QuoteService quoteService;
    @Autowired
    UserService userService;


    @Override
    public Vote castVote(Long userId, Long quoteId, String value) {
        Vote vote = findByQuoteAndUserId(quoteId, userId);
        Quote quote = quoteService.getQuoteById(quoteId);
        User user = userService.getUserById(userId);

        if (vote == null) {
            vote = new Vote();
            vote.setUser(user);
            vote.setQuote(quote);
            vote.setVoteType(VoteType.valueOf(value));
            voteRepository.save(vote);

            int c = 0;
            if (value.equals(VoteType.UP.toString()))
                c = 1;
            else if (value.equals(VoteType.DOWN.toString())) {
                c = -1;
            }
            quote.setRating(quote.getRating() + c);
            quoteRepository.save(quote);

        }
        else if (vote.getVoteType().equals(value)) {
            throw new AlreadyVotedException("User has already voted on this quote");

        }
        return vote;

    }


    @Override
    public Vote findByQuoteAndUserId(Long quoteId, Long userId) {
        return voteRepository.findVoteByQuoteIdAndUserId(quoteId, userId);
//        return voteRepository.findByQuoteIdAndUserId(quoteId, userId);
//        return voteRepository.existsVoteByQuoteIdAndUserId(quoteId, userId);
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
