package com.mycompany.shape01;
public class Circle extends Shape
{
    private double radius;
    Circle(double r)
    {
        radius =r;
    }
    double calculateArea()
    {
        return Math.PI*radius*radius;
    }
}
