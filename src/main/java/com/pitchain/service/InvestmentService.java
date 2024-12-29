package com.pitchain.service;

import com.pitchain.common.apiPayload.statusEnums.ErrorStatus;
import com.pitchain.common.exception.GeneralHandler;
import com.pitchain.entity.Bm;
import com.pitchain.entity.Investment;
import com.pitchain.entity.Member;
import com.pitchain.repository.BmRepository;
import com.pitchain.repository.InvestmentRepository;
import com.pitchain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class InvestmentService {

    private final InvestmentRepository investmentRepository;
    private final BmRepository bmRepository;
    private final MemberRepository memberRepository;

    public Long addInvestment(Long bmId, Long memberId, long amount) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new GeneralHandler(ErrorStatus.INVALID_MEMBER));

        Bm bm = bmRepository.findById(bmId).orElseThrow(() -> new GeneralHandler(ErrorStatus.INVALID_BM));
        Investment investment = Investment.builder()
                .member(member)
                .bm(bm)
                .amount(amount)
                .build();

        investmentRepository.save(investment);
        return investment.getId();
    }

}
