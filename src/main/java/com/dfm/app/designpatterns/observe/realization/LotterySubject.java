package com.dfm.app.designpatterns.observe.realization;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信 彩票 服务号
 * 服务号中维护了所有向它订阅消息的使用者，
 * 当服务号有新消息时，通知所有的使用者。
 * 整个架构是一种松耦合，主题的实现不依赖与使用者，当增加新的使用者时，主题的代码不需要改变；
 * 使用者如何处理得到的数据与主题无关；
 * @Author:fengming.dai
 */
@NoArgsConstructor
@ToString
@Data
public class LotterySubject implements Subject{

    //该 彩票服务号 的 订阅者 们。
    private  List<Observe> observes = new ArrayList<>();

    //模拟彩票号码
    private String msg;

    @Override
    public void registerObserve(Observe observe) {
        observes.add(observe);
    }

    @Override
    public void removeObserve(Observe observe) {
        int index = observes.indexOf(observe);
        if(index >= 0){
            observes.remove(index);
        }
    }

    @Override
    public void notifyObserve() {
        //通知每个订阅者，更新 消息
        observes.forEach(observe -> observe.update(msg));
    }
}
