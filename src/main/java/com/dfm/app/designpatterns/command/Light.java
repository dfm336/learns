package com.dfm.app.designpatterns.command;

import lombok.Data;

/**
 * @Author:fengming.dai
 */
@Data
public class Light {
    public void open(){
        System.out.println("打开电灯");
    }
    public void close(){
        System.out.println("关灯");
    }


}
