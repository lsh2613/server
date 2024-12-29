package com.pitchain.repository;

import com.pitchain.entity.Bm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BmRepository extends JpaRepository<Bm, Long> {
    @Query("SELECT b FROM Bm b "
            + "LEFT JOIN FETCH b.sp "
            + "WHERE b.id = :bmId")
    Optional<Bm> findByIdWithSp(@Param("bmId") Long bmId);
}
