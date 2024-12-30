package com.pitchain.repository;

import com.pitchain.entity.Bm;
import com.pitchain.entity.Member;
import com.pitchain.entity.MyBm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyBmRepository extends JpaRepository<MyBm, Long> {

    boolean existsByMemberAndBm(Member member, Bm bm);

    void deleteByMemberAndBm(Member member, Bm bm);
}
