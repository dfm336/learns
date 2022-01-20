package com.dfm.app.designpatterns.factory;

/**
 * @Author:fengming.dai
 */
public class ColorFactory extends AbstractFactory{
    @Override
    public Color getColor(String color) {
        switch (color){
            case "red": return new Red();
            case "blue": return new Blue();
            case "yello": return new Yello();
            default:break;
        }

        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
