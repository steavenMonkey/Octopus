package org.xuanchan.common.template;

/**
 * 模板服务接口，提供两种模板接口，分别是不带事务，带事务不带重试
 *
 * @author xuanchan
 * @date 2018年4月24日 下午10:39:05
 */
public interface TemplateService {

    /**
     * 执行不带事务的模板
     * 
     * @param action
     * @return
     */
    public SpotlightBizResult executeWithoutTrans(SpotlightCallBack<SpotlightBizResult> action);

    /**
     * 执行事务模板，不带重试
     * 
     * @param action
     * @return
     */
    public SpotlightBizResult executeTransWithoutRetry(
            SpotlightCallBack<SpotlightBizResult> action);
}
