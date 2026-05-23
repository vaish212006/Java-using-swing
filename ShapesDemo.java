package ec3108;

/**
 * Exercise 8:
 * Abstract Shape class with Rectangle, Triangle, Circle; each prints area.
 */
abstract class Shape {
    int a, b; // generic dimensions
    Shape(int a, int b) { this.a = a; this.b = b; }
    abstract void printArea();
}

class Rectangle extends Shape {
    Rectangle(int length, int breadth) { super(length, breadth); }
    @Override void printArea() {
        System.out.println("Rectangle area = " + (a * b));
    }
}

class Triangle extends Shape {
    Triangle(int base, int height) { super(base, height); }
    @Override void printArea() {
        System.out.println("Triangle area = " + (0.5 * a * b));
    }
}

class Circle extends Shape {
    Circle(int radius) { super(radius, 0); }
    @Override void printArea() {
        System.out.println("Circle area = " + (Math.PI * a * a));
    }
}

public class Ex08_ShapesDemo {
    public static void main(String[] args) {
        Shape r = new Rectangle(5, 7);
        Shape t = new Triangle(10, 6);
        Shape c = new Circle(4);
        r.printArea();
        t.printArea();
        c.printArea();
    }
}
