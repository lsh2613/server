package com.pitchain.controller;

import com.pitchain.common.apiPayload.dto.CustomApiResponse;
import com.pitchain.dto.res.BmDetailRes;
import com.pitchain.service.BmService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/bms")
@RestController
public class BmController {
    private final BmService bmService;

    @GetMapping("{bmId}")
    public CustomApiResponse<BmDetailRes> getBmDetail(@AuthenticationPrincipal Long memberId,
                                                      @PathVariable("bmId") Long bmId) {
        BmDetailRes bmDetailRes = bmService.getBmDetail(bmId);
        return CustomApiResponse.onSuccess(bmDetailRes);
    }

}
