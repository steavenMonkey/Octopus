package org.xuanchan.common.exception;

public class SpotlightBizException extends BasicRuntimeException{

    private static final long serialVersionUID = -3382114834234154718L;
    
    private SpotlightBizException(SpotlightBizErrorCodeEnum errorCode) {
        super(errorCode.getCode(), errorCode.getMessage());
    }


    private SpotlightBizException(SpotlightBizErrorCodeEnum errorCode, Throwable cause){
        super(errorCode.getCode(), errorCode.getMessage(), cause);
    }
    
    private SpotlightBizException(SpotlightBizErrorCodeEnum errorCode, String message, Throwable cause) {
        super(errorCode.getCode(), message, cause);
    }


    /**
     * 根据错误码返回业务异常
     * @param errorCode
     * @return
     */
    public static SpotlightBizException valueOf(SpotlightBizErrorCodeEnum errorCode){
        if(null == errorCode){
            return null;
        }
        return new SpotlightBizException(errorCode);
    }

    /**
     * 根据错误码和异常返回业务异常
     * @param errorCode
     * @param cause
     * @return
     */
    public static SpotlightBizException valueOf(SpotlightBizErrorCodeEnum errorCode, Throwable cause){
        if(null == errorCode || cause == null){
            return null;
        }
        return new SpotlightBizException(errorCode, cause);
    }
    
    /**
      *根据错误码,错误描述，异常返回业务异常
      *
      * @param @param errorCode
      * @param @param message
      * @param @param cause
      * @return SpotlightBizException
      * @throws
     */
    public static SpotlightBizException valuOf(SpotlightBizErrorCodeEnum errorCode, String message, Throwable cause) {
        return new SpotlightBizException(errorCode, message, cause);
    }

}
