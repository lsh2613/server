package com.pitchain.controller;

import com.pitchain.common.apiPayload.dto.CustomApiResponse;
import com.pitchain.service.InvestmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/bms")
@RequiredArgsConstructor
public class InvestmentController {

    private final InvestmentService investmentService;

    @PostMapping("/{bmId}/invest")
    public CustomApiResponse<Map<String, Long>> addInvestment(@PathVariable("bmId") Long bmId,
                                                              @AuthenticationPrincipal Long memberId,
                                                              @RequestBody Map<String, Long> body) {
        Long amount = body.get("amount");
        Long investmentId = investmentService.addInvestment(bmId, memberId, amount);

        Map<String, Long> result = new HashMap<>();
        result.put("investmentId", investmentId);
        return CustomApiResponse.onSuccess(result);
    }
}
