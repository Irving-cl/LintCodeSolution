/**
 * Your object will be instantiated and called as such:
 * ShapeFactory sf = new ShapeFactory();
 * Shape shape = sf.getShape(shapeType);
 * shape.draw();
 */
interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println(" ---- ");
        System.out.println("|    |");
        System.out.println(" ---- ");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println(" ----");
        System.out.println("|    |");
        System.out.println("|    |");
        System.out.println(" ----");
    }
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("  /\\ ");
        System.out.println(" /  \\");
        System.out.println("/____\\");
    }
}

public class ShapeFactory {
    /**
     * @param shapeType a string
     * @return Get object of type Shape
     */
    public Shape getShape(String shapeType) {
        if (shapeType.equals("Square")) {
            return new Square();
        } else if (shapeType.equals("Rectangle")) {
            return new Rectangle();
        } else {
            return new Triangle();
        }
    }
}