package com.dfm.app.designpatterns.observe.realizationbyjdk;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author:fengming.dai
 */
public class ObserveD implements Observer {
    public void registerObservable(Observable observable){
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof TechnologySubject){
            System.out.println("D recived TechnologyySubject's msg:"+((TechnologySubject) o).msg);
        }
    }
}
