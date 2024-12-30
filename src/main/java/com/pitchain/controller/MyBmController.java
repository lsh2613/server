package com.pitchain.controller;

import com.pitchain.common.apiPayload.dto.CustomApiResponse;
import com.pitchain.service.MyBmService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bms")
@RequiredArgsConstructor
public class MyBmController {

    private final MyBmService myBmService;

    @PostMapping("/{bmId}/like")
    public CustomApiResponse toggleLikeBm(@PathVariable("bmId") Long bmId,
                                          @AuthenticationPrincipal Long memberId) {
        myBmService.toggleLikeBm(bmId, memberId);
        return CustomApiResponse.onSuccess();
    }
}
