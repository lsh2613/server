package com.pitchain.service;

import com.pitchain.entity.Bm;
import com.pitchain.entity.Investment;
import com.pitchain.entity.Member;
import com.pitchain.repository.BmRepository;
import com.pitchain.repository.InvestmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class InvestmentService {

    private final InvestmentRepository investmentRepository;
    private final BmRepository bmRepository;

    public Long addInvestment(Long bmId, Member member, long amount) {
        Bm bm = bmRepository.findById(bmId).orElseThrow();
        Investment investment = Investment.builder()
                .member(member)
                .bm(bm)
                .amount(amount)
                .build();

        investmentRepository.save(investment);
        return investment.getId();
    }

}
