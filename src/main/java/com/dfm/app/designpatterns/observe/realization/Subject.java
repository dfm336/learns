package com.dfm.app.designpatterns.observe.realization;

/**
 * 主题接口
 * @Author:fengming.dai
 */
public interface Subject {
    /**
     * 注册一个观察者，（订阅主题）
     * @param observe
     */
    void registerObserve(Observe observe);

    /**
     * 移除一个观察者，（取消订阅）
     * @param observe
     */
    void removeObserve(Observe observe);

    /**
     * 通知所有观察者，（推送更新）
     */
    void notifyObserve();
}
