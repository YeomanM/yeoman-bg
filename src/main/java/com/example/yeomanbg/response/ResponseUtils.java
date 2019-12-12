package com.example.yeomanbg.response;

public class ResponseUtils {

    public static BaseResponse success() {
        return ResponseUtils.success("success", null);
    }

    public static BaseResponse success(Object data) {
        return ResponseUtils.success("success", data);
    }

    public static BaseResponse success(String msg, Object data) {
        return ResponseUtils.instance(200, msg, data);
    }

    public static BaseResponse fail() {
        return ResponseUtils.fail("fail");
    }

    public static BaseResponse fail(String errorMsg) {
        return ResponseUtils.fail(400, errorMsg);
    }

    public static BaseResponse fail(int errorCode) {
        return ResponseUtils.fail(errorCode, "fail");
    }

    public static BaseResponse fail(int errorCode, String errorMsg) {
        return ResponseUtils.instance(errorCode, errorMsg, null);
    }




    private static BaseResponse instance(int errorCode, String errorMsg, Object data) {
        return new BaseResponse(errorCode, errorMsg, data);
    }
}
