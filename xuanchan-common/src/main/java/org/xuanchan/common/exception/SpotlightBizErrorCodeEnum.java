package org.xuanchan.common.exception;

public enum SpotlightBizErrorCodeEnum {

    INVALID_PARAM("INVALID_PARAM", "无效的参数"), UNKONW_ERROR("UNKOWN_ERROR", "系统未知异常"),;

    private String code;
    private String message;

    SpotlightBizErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

}
