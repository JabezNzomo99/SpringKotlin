package com.ics.micmaestro.OOP;

public class Rectangle extends Shape implements Perimeter {
    private Double length;
    private Double width;

    public Rectangle(ShapeType shapeType, Double length, Double width) {
        super(shapeType);
        this.length = length;
        this.width = width;
        calculateArea();
        calculatePerimeter();
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public void calculateArea() {
        area = length*width;
    }

    @Override
    public void calculatePerimeter() {
        perimeter = (length*2)+(width*2);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                ", perimeter=" + perimeter +
                ", area=" + area +
                ", shapeType=" + shapeType +
                '}';
    }
}
