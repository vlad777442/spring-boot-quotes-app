package com.kameleoon.quotesmanager.repository;

import com.kameleoon.quotesmanager.model.Quote;
import com.kameleoon.quotesmanager.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

//    @Query("SELECT COUNT(v) FROM Vote v WHERE v.user.id = :userId AND v.quote.id = :quoteId")
//    long countByUserIdAndQuoteId(@Param("userId") Long userId, @Param("quoteId") Long quoteId);



    Vote findByQuoteIdAndUserId(Long quoteId, Long userId);
    Vote existsVoteByQuoteIdAndUserId(Long quoteId, Long userId);
    Vote findVoteByQuoteIdAndUserId(Long userId, Long quoteId);

}
