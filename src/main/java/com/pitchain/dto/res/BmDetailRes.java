package com.pitchain.dto.res;

import com.pitchain.entity.Bm;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record BmDetailRes(
        Long id,
        String name,
        String category,
        String logoImg,
        String description,
        String descriptionImg,
        String address,
        Long valuationCap,
        LocalDate deadline,
        LocalDateTime createdAt,
        Integer investmentGoal,
        String longPitchUrl,
        String spURL,
        boolean isLiked // todo MyBm 개발 완료 후 추가 예정
) {
    public static BmDetailRes createRes(Bm bm) {
        return BmDetailRes.builder()
                .id(bm.getId())
                .name(bm.getName())
                .category(bm.getCategory().name())
                .logoImg(bm.getLogoImg())
                .description(bm.getDescription())
                .descriptionImg(bm.getDescriptionImg())
                .address(bm.getAddress())
                .valuationCap(bm.getValuationCap())
                .deadline(bm.getDeadline())
                .createdAt(bm.getCreatedAt())
                .investmentGoal(bm.getInvestmentGoal())
                .longPitchUrl(bm.getLongPitchUrl())
                .spURL(bm.getSp().getShortPitchURL())
                .build();
    }
}
