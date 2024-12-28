package com.pitchain.common.apiPayload.statusEnums;

import com.pitchain.common.apiPayload.dto.ResponseDTO;

public interface ResponseStatus {

    public ResponseDTO getDto();

    public ResponseDTO getHttpStatusDto();

}
