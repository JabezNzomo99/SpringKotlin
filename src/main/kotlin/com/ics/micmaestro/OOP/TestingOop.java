package com.ics.micmaestro.OOP;

public class TestingOop {
    public static void main(String args[]) {
        Shape rectangle = new Rectangle(ShapeType.TWO_D,4.3,5.6);
        Shape circle = new Circle(ShapeType.TWO_D,7.0);
        Shape triangle = new Triangle(ShapeType.TWO_D,3.0,4.0);

        System.out.println(rectangle.toString());
        System.out.println(circle.toString());
        System.out.println(triangle.toString());



    }

}
