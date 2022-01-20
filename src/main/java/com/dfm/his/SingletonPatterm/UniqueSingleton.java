package com.dfm.his.SingletonPatterm;

/**
 * @author dfm
 * @create 2020-09-30 10:44
 */
public class UniqueSingleton {
    private static volatile UniqueSingleton instance;

    private UniqueSingleton(){};

    public static UniqueSingleton getInstance(){
        if(instance == null){
            synchronized (UniqueSingleton.class){
                if(instance == null){
                    instance = new UniqueSingleton();
                }
            }
        }
        return instance;
    }
}
