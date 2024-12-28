package com.pitchain.controller;

import com.pitchain.entity.Member;
import com.pitchain.service.InvestmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity addInvestment(@PathVariable("bmId") Long bmId,
                                        @AuthenticationPrincipal Member member,
                                        @RequestBody Map<String, Long> body) {
        Long amount = body.get("amount");
        Long investmentId = investmentService.addInvestment(bmId, member, amount);

        Map<String, Long> result = new HashMap<>();
        result.put("investmentId", investmentId);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }
}
