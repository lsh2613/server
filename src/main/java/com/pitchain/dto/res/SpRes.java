package com.pitchain.dto.res;

import com.pitchain.entity.Sp;
import lombok.Builder;

@Builder
public record SpRes(
        Long bmId,
        String shortPitchURL,
        String thumbnailImg,
        int views,
        String description
) {
    public static SpRes createRes(Sp sp) {
        return SpRes.builder()
                .bmId(sp.getBm().getId())
                .shortPitchURL(sp.getShortPitchURL())
                .thumbnailImg(sp.getThumbnailImg())
                .views(sp.getViews())
                .description(sp.getDescription())
                .build();
    }
}
