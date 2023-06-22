package com.mycompany.shape01;
public class Rectangle extends Shape 
{
    private double height,width;
    Rectangle(double h,double w)
    {
        height =h;
        width=w;
    }
    double calculateArea()
    {
        return height*width;
    }
}
