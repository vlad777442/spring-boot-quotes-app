package com.kameleoon.quotesmanager.mapper;

import com.kameleoon.quotesmanager.dto.QuoteRequestDTO;
import com.kameleoon.quotesmanager.dto.QuoteResponseDTO;
import com.kameleoon.quotesmanager.model.Quote;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface QuoteMapper {
    QuoteResponseDTO toQuoteResponseDTO(Quote quote);

    QuoteRequestDTO toQuoteRequestDTO(Quote quote);

    Quote toQuote(QuoteRequestDTO quoteRequestDTO);

    List<QuoteResponseDTO> toQuoteResponseDTOList(List<Quote> quotes);
}
