package com.dfm.app.designpatterns.factory;

/**
 * 抽象工厂类
 * @Author:fengming.dai
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}
