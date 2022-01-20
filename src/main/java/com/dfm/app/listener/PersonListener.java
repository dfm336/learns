package com.dfm.app.listener;

/**
 * 监听器定义为接口，监听的方法需要事件对象传递进来，从而在监听器上通过事件对象获取得到事件源，对事件源进行修改！
 * @Author:代奉明
 */
public interface PersonListener {

    void doEat(Event event);

    void doSleep(Event event);
}
