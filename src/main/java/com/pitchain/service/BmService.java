package com.pitchain.service;

import com.pitchain.common.apiPayload.statusEnums.ErrorStatus;
import com.pitchain.common.exception.GeneralHandler;
import com.pitchain.dto.res.BmDetailRes;
import com.pitchain.entity.Bm;
import com.pitchain.repository.BmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class BmService {
    private final BmRepository bmRepository;

    @Transactional(readOnly = true)
    public BmDetailRes getBmDetail(Long bmId) {
        Bm bm = bmRepository.findByIdWithSp(bmId).orElseThrow(
                () -> new GeneralHandler(ErrorStatus.BM_NOT_FOUND)
        );

        return BmDetailRes.createRes(bm);
    }
}
