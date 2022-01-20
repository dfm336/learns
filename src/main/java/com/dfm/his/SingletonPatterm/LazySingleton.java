package com.dfm.his.SingletonPatterm;

/**
 * 懒汉式单例
 * 它懒，等你要得到实例，getInstance的时候在去初始化。
 * @author dfm
 * @create 2020-08-28 14:28
 */
public class LazySingleton {
    private static  LazySingleton instance;

    private LazySingleton(){}

    public static synchronized LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
