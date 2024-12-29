package com.pitchain.dto;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

public class InvestmentDto {

    @Getter
    @Setter
    public static class RequestDto {

        @Positive
        private long amount;
    }

    @Getter
    @Setter
    public static class ResponseDto {

        private Long investmentId;
    }
}
