package com.dfm.app.listener;

/**
 * 事件源
 * 事件源要提供方法  注册监听器--即 在事件源上 关联监听器对象
 * @Author:代奉明
 */
public class Person {
    //成员变量 定义一个监听器对象
    private PersonListener personListener;

    /**
     * 在事件源中 定义两个方法 eat， sleep
     */
    public void eat(){
        /**
         * 当事件源 调用了 eat 方法，应该触发监听器的方法，调用监听器的方法并把对象传递进去
         */
        this.personListener.doEat(new Event(this));
    }

    public void sleep(){
        personListener.doSleep(new Event(this));
    }
    //注册监听器，该类没有监听器对象，那就注册进来吧
    public  void registerListener(PersonListener personListener){
        this.personListener = personListener;
    }
}
