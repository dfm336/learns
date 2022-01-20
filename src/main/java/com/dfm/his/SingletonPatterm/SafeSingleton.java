package com.dfm.his.SingletonPatterm;


/**
 * 双检锁/双重校验锁 + volatile关键字
 * @author dfm
 * @create 2020-08-28 14:34
 */
public class SafeSingleton {
    private static volatile SafeSingleton instance = null;

    private  SafeSingleton(){}

    public static SafeSingleton getInstance(){
        if(instance == null){
            synchronized (SafeSingleton.class){
                if(instance == null){
                    instance = new SafeSingleton();
                }
            }
        }
        return instance;
    }
}
