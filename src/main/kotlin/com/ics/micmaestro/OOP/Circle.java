package com.ics.micmaestro.OOP;

public class Circle extends Shape implements Perimeter {

    private Double radius;

    public Circle(ShapeType shapeType,Double radius) {
        super(shapeType);
        this.radius = radius;
        calculateArea();
        calculatePerimeter();
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        area = Math.PI*radius*radius;
    }

    @Override
    public void calculatePerimeter() {
        perimeter = Math.PI*2*radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", perimeter=" + perimeter +
                ", area=" + area +
                ", shapeType=" + shapeType +
                '}';
    }
}
