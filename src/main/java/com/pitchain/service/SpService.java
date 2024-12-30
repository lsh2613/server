package com.pitchain.service;

import com.pitchain.common.apiPayload.statusEnums.ErrorStatus;
import com.pitchain.common.exception.GeneralHandler;
import com.pitchain.dto.res.SpRes;
import com.pitchain.entity.Sp;
import com.pitchain.repository.SpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class SpService {
    private final SpRepository spRepository;

    @Transactional(readOnly = true)
    public List<SpRes> getSps() {
        List<Sp> sps = spRepository.findAll();
        return sps.stream().map(SpRes::createRes).toList();
    }

    @Transactional(readOnly = true)
    public SpRes getSp(Long bmId) {
        Sp sp = spRepository.findById(bmId).orElseThrow(
                () -> new GeneralHandler(ErrorStatus.SP_NOT_FOUND)
        );

        return SpRes.createRes(sp);
    }
}
