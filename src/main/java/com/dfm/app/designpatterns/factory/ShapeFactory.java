package com.dfm.app.designpatterns.factory;

/**
 * @Author:fengming.dai
 */
public class ShapeFactory extends AbstractFactory{
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        switch (shape){
            case "circle": return new Circle();
            case "rectenge": return new Rectenge();
            case "square": return new Square();
            default:break;
        }
        return null;
    }
}
