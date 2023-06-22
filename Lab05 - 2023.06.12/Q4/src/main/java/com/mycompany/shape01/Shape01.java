package com.mycompany.shape01;
public class Shape01 
{
    public static void main(String[] args) 
    {
        Circle c = new Circle(10);
        double circleArea = c.calculateArea();
        c.display();
        System.out.println("Area of the circle: "+c.calculateArea());
        
        Rectangle r = new Rectangle(10,20);
        double rectangleArea = r.calculateArea();
        r.display();
        System.out.println("Area of the rectangle: "+r.calculateArea());
    }
}
