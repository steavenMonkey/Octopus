package org.xuanchan.common.exception;

/**
 * @author daijiansheng
 * @date 2017年4月21日
 */
public class BasicException extends Exception {

    static final long serialVersionUID = 1L;

    private final String code;

    public BasicException(String errMsg) {

        super(errMsg);
        this.code="";
    }

    public BasicException(String errMsg, Throwable cause) {

        super(errMsg, cause);
        this.code="";
    }

    public BasicException(String code, String errMsg) {

        super(errMsg);
        this.code=code;
    }

    public BasicException(String code, String errMsg, Throwable cause) {

        super(errMsg, cause);
        this.code=code;
    }

    public String getCode() {
        return code;
    }

}
