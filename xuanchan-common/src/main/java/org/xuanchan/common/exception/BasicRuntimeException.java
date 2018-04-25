package org.xuanchan.common.exception;

/**
 * @author daijiansheng
 * @date 2017年4月21日
 */
public class BasicRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String code;

    public BasicRuntimeException(String errMsg) {

        super(errMsg);
        this.code = "";
    }

    public BasicRuntimeException(String errMsg, Throwable cause) {

        super(errMsg, cause);
        this.code = "";
    }

    public BasicRuntimeException(String code, String errMsg) {

        super(errMsg);
        this.code = code;
    }

    public BasicRuntimeException(String code, String errMsg, Throwable cause) {

        super(errMsg, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
