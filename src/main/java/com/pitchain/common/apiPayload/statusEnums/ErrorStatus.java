package com.pitchain.common.apiPayload.statusEnums;

import com.pitchain.common.apiPayload.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements ResponseStatus {

    // common
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // jwt
    MISSING_ACCESS_TOKEN(HttpStatus.BAD_REQUEST, "TOKEN4012", "Access Token이 존재하지 않습니다."),

    // member
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER4041", "존재하지 않는 사용자입니다."),

    // bm
    BM_NOT_FOUND(HttpStatus.NOT_FOUND, "BM4041", "존재하지 않는 BM입니다."),

    // sp
    SP_NOT_FOUND(HttpStatus.NOT_FOUND, "SP4041", "존재하지 않는 SP입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ResponseDTO getDto() {
        return ResponseDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ResponseDTO getHttpStatusDto() {
        return ResponseDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
