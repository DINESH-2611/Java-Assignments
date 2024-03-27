package ploymorphism;

abstract public class Shape {

    double base;
    double height;
    double area;
    double perimeter;

    public Shape(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public abstract void findArea() ;
    public abstract void findPerimeter() ;

}
    class Rectangle extends Shape {

        public Rectangle(double base, double height,double side1,double side2) {
            super(base, height);
        }
        public void findArea(){
            area=base*height;
        }
        public void findPerimeter(){
            perimeter=2*(base*height);
        }
    }
    class Triangle extends Shape {
        double side1;
        double side2;
        public Triangle(double base, double height) {
            super(base, height);
            this.side1=side1;
            this.side2=side2;
        }
        public void findArea(){
            area=0.5*base*height;
        }
        public void findPerimeter(){
            perimeter=base+side1+side2;
        }
    }

