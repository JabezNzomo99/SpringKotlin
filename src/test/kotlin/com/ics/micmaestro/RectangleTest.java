package com.ics.micmaestro;

import com.ics.micmaestro.OOP.Rectangle;
import com.ics.micmaestro.OOP.ShapeType;
import org.junit.Before;
import org.junit.Test;

public class RectangleTest {
    private Rectangle rectangle;

    @Before
    public void setUp(){
        rectangle = new Rectangle(ShapeType.TWO_D,10.0,10.0);
    }

    @Test
    public void testPerimeter(){
        rectangle.calculatePerimeter();

    }
}
