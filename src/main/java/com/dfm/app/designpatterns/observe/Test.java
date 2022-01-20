package com.dfm.app.designpatterns.observe;

import com.dfm.app.designpatterns.observe.realization.LotterySubject;
import com.dfm.app.designpatterns.observe.realization.ObserveA;
import com.dfm.app.designpatterns.observe.realization.ObserveB;
import com.dfm.app.designpatterns.observe.realizationbyjdk.ObserveC;
import com.dfm.app.designpatterns.observe.realizationbyjdk.ObserveD;
import com.dfm.app.designpatterns.observe.realizationbyjdk.TechnologySubject;

/**
 * 观察者模式：定义了对象之间一对多的依赖，当一个对象改变时，它的所有依赖都会收到通知并自动更新
 * @Author:fengming.dai
 */
public class Test {
    public static void main(String[] args) {
        testJdkRealization();
    }
    public static void testJdkRealization(){
        TechnologySubject technologySubject = new TechnologySubject();
        ObserveC observeC = new ObserveC();
        observeC.registerObservable(technologySubject);
        ObserveD observeD = new ObserveD();
        observeD.registerObservable(technologySubject);
        technologySubject.setMsg("消息1");

        technologySubject.setMsg("消息2");

    }
    public static void testMyRealization(){
        LotterySubject lotterySubject = new LotterySubject();
        ObserveA observeA = new ObserveA(lotterySubject);
        ObserveB observeB = new ObserveB(lotterySubject);
        lotterySubject.setMsg("msg 1");
        lotterySubject.notifyObserve();

        lotterySubject.removeObserve(observeA);
        lotterySubject.setMsg("msg 2");
        lotterySubject.notifyObserve();
    }
}
