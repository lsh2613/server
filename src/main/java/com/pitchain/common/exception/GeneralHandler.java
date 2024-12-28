package com.pitchain.common.exception;

import com.pitchain.common.apiPayload.statusEnums.ResponseStatus;
import com.pitchain.common.apiPayload.dto.ResponseDTO;
import lombok.Getter;

@Getter
public class GeneralHandler extends RuntimeException {

    private ResponseStatus errorStatus;

    public GeneralHandler(ResponseStatus errorStatus) {
        super(errorStatus.getDto().getMessage());
        this.errorStatus = errorStatus;
    }

    public ResponseDTO getError() {
        return this.errorStatus.getDto();
    }

    public ResponseDTO getErrorHttpStatus() {
        return this.errorStatus.getHttpStatusDto();
    }
}
