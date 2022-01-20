package com.dfm.app.designpatterns.observe.realization;

/**
 * 观察者接口
 * @Author:fengming.dai
 */
public interface Observe {
    /**
     * 所有的观察者都要实现该接口
     * @param msg
     */
    void update(String msg);
}
