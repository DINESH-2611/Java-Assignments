package constructorsandinheritence;

import java.util.Scanner;

public class Shape {
    double base;
    double height;
    public Shape(){
    }
    public Shape(double base, double height) {
        this.base = base;
        this.height = height;
    }

}
class Rectangle extends Shape {
    public Rectangle(double base, double height) {
        super(base, height);
    }
}
class Triangle extends Shape {
    public Triangle(double base, double height) {
        super(base, height);
    }
}
class Circle extends Shape{
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double base, double height, double radius) {
        super(base, height);
        this.radius = radius;
    }
}
