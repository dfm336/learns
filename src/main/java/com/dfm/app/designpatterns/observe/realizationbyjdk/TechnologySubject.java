package com.dfm.app.designpatterns.observe.realizationbyjdk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Observable;

/**
 * @Author:fengming.dai
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TechnologySubject extends Observable {
    String msg;

    public void setMsg(String msg) {
        this.msg = msg;
        //在父类Observable 中定义了 changed 是否改变标识符
        //标记 msg 改变
        setChanged();
        //通知 observes
        notifyObservers();
    }
}
