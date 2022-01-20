package com.dfm.app.fanxing;

/**
 * @Author:代奉明
 */
public interface Handler<T extends User>{
    T deal(String content);
}
