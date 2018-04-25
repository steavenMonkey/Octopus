/*******************************************************************************
 * $Header$ $Revision$ $Date$
 *
 * ==============================================================================
 *
 * youzan-inc.com.
 * 
 * Created on 2018年4月25日
 *******************************************************************************/


package org.xuanchan.common.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.xuanchan.common.exception.SpotlightBizErrorCodeEnum;
import org.xuanchan.common.exception.SpotlightBizException;
import org.xuanchan.common.util.LoggerUtil;

/**
 * 模板服务实现类
 * 
 * @author xuanchan
 * @date 2018年4月25日 下午5:13:30
 */

public class TemplateServiceImpl implements TemplateService {

    private Logger logger = LoggerFactory.getLogger(TemplateServiceImpl.class);

    private TransactionTemplate transTemplate;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.youzan.ebiz.spotlight.basic.biz.service.template.TemplateService#executeWithoutTrans(com.
     * youzan.ebiz.spotlight.basic.biz.service.template.SpotlightCallBack)
     */
    @Override
    public SpotlightBizResult executeWithoutTrans(SpotlightCallBack<SpotlightBizResult> action) {
        SpotlightServiceContext spbServiceCtx = new SpotlightServiceContext();
        try {
            action.init(spbServiceCtx);
            SpotlightBizResult result = action.doService(spbServiceCtx);
            action.afterService(spbServiceCtx);
            return result;
        } catch (SpotlightBizException e) {
            LoggerUtil.error(logger, e.getCause(), "初始化失败,errorCode=%s", e.getCode());
            return SpotlightBizResult.valueOfError(e.getCode(), e.getMessage());
        } catch (Throwable t) {
            LoggerUtil.error(logger, t, "初始化失败,errorCode=%s",
                    SpotlightBizErrorCodeEnum.UNKONW_ERROR.getCode());
            return SpotlightBizResult.valueOfError(SpotlightBizErrorCodeEnum.UNKONW_ERROR.getCode(),
                    "初始化失败，未知异常");
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.youzan.ebiz.spotlight.basic.biz.service.template.TemplateService#executeTransWithoutRetry
     * (com.youzan.ebiz.spotlight.basic.biz.service.template.SpotlightCallBack)
     */
    @Override
    public SpotlightBizResult executeTransWithoutRetry(
            SpotlightCallBack<SpotlightBizResult> action) {
        SpotlightServiceContext spbServiceCtx = new SpotlightServiceContext();
        try {
            action.init(spbServiceCtx);
            SpotlightBizResult result = action.doService(spbServiceCtx);
            action.afterService(spbServiceCtx);
        } catch (SpotlightBizException e) {
            LoggerUtil.error(logger, e.getCause(), "初始化失败,errorCode=%s", e.getCode());
            return SpotlightBizResult.valueOfError(e.getCode(), e.getMessage());
        } catch (Throwable t) {
            LoggerUtil.error(logger, t, "初始化失败,errorCode=%s",
                    SpotlightBizErrorCodeEnum.UNKONW_ERROR.getCode());
            return SpotlightBizResult.valueOfError(SpotlightBizErrorCodeEnum.UNKONW_ERROR.getCode(),
                    "初始化失败，未知异常");
        }

        try {
            SpotlightBizResult spotlightBizResult =
                    transTemplate.execute(new TransactionCallback<SpotlightBizResult>() {
                        @Override
                        public SpotlightBizResult doInTransaction(TransactionStatus status) {
                            SpotlightBizResult result = action.doService(spbServiceCtx);
                            action.afterService(spbServiceCtx);
                            return result;
                        }
                    });
            return spotlightBizResult;
        } catch (SpotlightBizException e) {
            LoggerUtil.error(logger, e.getCause(), "初始化失败,errorCode=%s", e.getCode());
            return SpotlightBizResult.valueOfError(e.getCode(), e.getMessage());
        } catch (Throwable t) {
            LoggerUtil.error(logger, t, "初始化失败,errorCode=%s",
                    SpotlightBizErrorCodeEnum.UNKONW_ERROR.getCode());
            return SpotlightBizResult.valueOfError(SpotlightBizErrorCodeEnum.UNKONW_ERROR.getCode(),
                    "初始化失败，未知异常");
        }

    }


}

/*
 * 修改历史 $Log$
 */
