/*******************************************************************************
 * $Header$
 * $Revision$
 * $Date$
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2012 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2018年4月24日
 *******************************************************************************/


package org.xuanchan.common.template;

import java.util.HashMap;
import java.util.Map;

/**
 * 回调服务内部上下文
 * @author xuanchan
 * @date 2018年4月24日 下午10:46:44
 */

public class SpotlightServiceContext {
    
    private Map<String, Object> params = new HashMap<>();

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
    
}

/*
 * 修改历史
 * $Log$ 
 */