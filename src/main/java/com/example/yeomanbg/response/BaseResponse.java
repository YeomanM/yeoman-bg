package com.example.yeomanbg.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseResponse {

    private int errorCode;
    private String errorMsg;
    private Object data;

    public BaseResponse() {
    }

    public BaseResponse(int errorCode, String errorMsg, Object data) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }
}
