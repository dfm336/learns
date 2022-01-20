package com.dfm.app.designpatterns.factory;

/**
 * @Author:fengming.dai
 */
public class Test {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        Shape rectenge = shapeFactory.getShape("rectenge");
        rectenge.drew();

        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        Color blue = colorFactory.getColor("blue");
        blue.fill();
    }
}
