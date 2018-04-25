package org.xuanchan.common.template;

import java.util.HashMap;
import java.util.Map;

/**
 * 精选业务结果类
 * 
 * @author Comsys-genzen
 * @date 2018年4月24日 下午4:16:44
 * @Company: youzan-inc.com
 */
public class SpotlightBizResult {

    /** 是否成功，成功：true，失败：false */
    private boolean isSuccess;

    /** 失败错误码 */
    private String errCode;

    /** 消息 */
    private String message;

    /** 返回值对象容器 */
    private Map<String, Object> retParams = new HashMap<>();

    public SpotlightBizResult(boolean isSuccess, String errCode, String message,
            Map<String, Object> retParams) {
        this.isSuccess = isSuccess;
        this.errCode = errCode;
        this.message = message;
        this.retParams = retParams;
    }

    /**
     * 返回成功结果，带描述和结果值
     * 
     * @param message
     * @param retParams
     * @return
     */
    public static SpotlightBizResult valueOfSuccsess(String message,
            Map<String, Object> retParams) {
        return new SpotlightBizResult(true, null, message, retParams);
    }

    /**
     * 根据错误码和描述返回失败结果
     * 
     * @param errCode
     * @param message
     * @return
     */
    public static SpotlightBizResult valueOfError(String errCode, String message) {
        return new SpotlightBizResult(false, errCode, message, null);
    }



    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getRetParams() {
        return retParams;
    }

    public void setRetParams(Map<String, Object> retParams) {
        this.retParams = retParams;
    }



}
