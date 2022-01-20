package com.dfm.his.SingletonPatterm;

/**
 * 饿汉式单例模式
 * 它太饿了，定义的时候就直接给他初始化了。等你获取实例（getInstatnce）的时候返回给你。
 * @author dfm
 * @create 2020-08-28 14:21
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){
    }

    public static synchronized HungrySingleton getInstance() {

        return instance;
    }
}
