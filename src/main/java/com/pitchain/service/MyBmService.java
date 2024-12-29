package com.pitchain.service;

import com.pitchain.common.apiPayload.statusEnums.ErrorStatus;
import com.pitchain.common.exception.GeneralHandler;
import com.pitchain.entity.Bm;
import com.pitchain.entity.Member;
import com.pitchain.entity.MyBm;
import com.pitchain.repository.BmRepository;
import com.pitchain.repository.MemberRepository;
import com.pitchain.repository.MyBmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MyBmService {

    private final MyBmRepository myBmRepository;
    private final MemberRepository memberRepository;
    private final BmRepository bmRepository;

    public boolean toggleMyBm(Long bmId, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new GeneralHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Bm bm = bmRepository.findById(bmId).orElseThrow(() -> new GeneralHandler(ErrorStatus.BM_NOT_FOUND));

        if (isToggled(member, bm)) {
            cancelLike(member, bm);
            return false;
        }

        addLike(member, bm);
        return true;
    }

    @Transactional(readOnly = true)
    private boolean isToggled(Member member, Bm bm) {
        return myBmRepository.existsByMemberAndBm(member, bm);
    }

    private void addLike(Member member, Bm bm) {
        MyBm myBm = new MyBm(member, bm);
        myBmRepository.save(myBm);
    }

    private void cancelLike(Member member, Bm bm) {
        myBmRepository.deleteByMemberAndBm(member, bm);
    }


}
