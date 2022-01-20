package com.dfm.app.designpatterns.observe.realization;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author:fengming.dai
 */
@Data
@NoArgsConstructor
@ToString
public class ObserveA implements Observe{

    private Subject subject;

    public ObserveA(Subject subject){
        this.subject = subject;
        this.subject.registerObserve(this);
    }

    @Override
    public void update(String msg) {
        System.out.println("observeA 接收到 更新！！！"+msg);
    }
}
