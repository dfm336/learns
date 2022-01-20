package com.dfm.app.designpatterns.factory;

/**
 * @Author:fengming.dai
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String type){
        if("shape".equals(type)){
            return new ShapeFactory();
        }
        if("color".equals(type)){
            return new ColorFactory();
        }
        return null;
    }
}
