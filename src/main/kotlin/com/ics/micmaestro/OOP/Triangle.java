package com.ics.micmaestro.OOP;

public class Triangle extends Shape implements Perimeter {
    private Double base;
    private Double height;

    public Triangle(ShapeType shapeType, Double base, Double height) {
        super(shapeType);
        this.base = base;
        this.height = height;
        calculateArea();
        calculatePerimeter();
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public void calculateArea() {
        area = 0.5*base*height;
    }

    @Override
    public void calculatePerimeter() {
        double hypotenuse= Math.sqrt((height*height)+(base*base));
        perimeter = hypotenuse + base + height;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "base=" + base +
                ", height=" + height +
                ", perimeter=" + perimeter +
                ", area=" + area +
                ", shapeType=" + shapeType +
                '}';
    }
}
