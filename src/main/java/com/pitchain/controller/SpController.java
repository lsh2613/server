package com.pitchain.controller;

import com.pitchain.common.apiPayload.dto.CustomApiResponse;
import com.pitchain.dto.res.SpRes;
import com.pitchain.service.SpService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/sps")
@RestController
public class SpController {
    private final SpService spService;

    @GetMapping
    public CustomApiResponse<List<SpRes>> getSps(@AuthenticationPrincipal Long memberId) {
        List<SpRes> spResList = spService.getSps();
        return CustomApiResponse.onSuccess(spResList);
    }

    @GetMapping("/{bmId}")
    public CustomApiResponse<SpRes> getSp(@AuthenticationPrincipal Long memberId,
                                          @PathVariable Long bmId) {
        SpRes spRes = spService.getSp(bmId);
        return CustomApiResponse.onSuccess(spRes);
    }
}
