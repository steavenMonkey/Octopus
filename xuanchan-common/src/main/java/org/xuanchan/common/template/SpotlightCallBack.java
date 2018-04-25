package org.xuanchan.common.template;

/**
 * 模板回调接口
 * 
 * @author xuanchan
 * @date 2018年4月24日 下午10:51:47
 */
public interface SpotlightCallBack<T> {

    /**
     * 初始化
     * 
     * @param spbServiceCtx
     */
    public void init(SpotlightServiceContext spbServiceCtx);

    /**
     * 服务执行，调用具体的业务逻辑
     * 
     * @param spbServiceCtx
     * @return
     */
    public T doService(SpotlightServiceContext spbServiceCtx);

    /**
     * 服务执行完后的操作
     * 
     * @param spbServiceCtx
     * @return
     */
    public void afterService(SpotlightServiceContext spbServiceCtx);
}
