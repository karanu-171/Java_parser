package org.example.Shapes;

import java.util.ArrayList;
import java.util.List;

public class Circle implements Shape {
    private String label;
    private List<Shape> innerShapes;

    public Circle(String label) {
        this.label = label;
        this.innerShapes = new ArrayList<>();
    }

    @Override
    public String getLabel() {
        return label;
    }

    public void addInnerShape(Shape shape) {
        innerShapes.add(shape);
    }

    public List<Shape> getInnerShapes() {
        return innerShapes;
    }

    @Override
    public String toString() {
        return "Circle(" + label + ", innerShapes=" + innerShapes + ")";
    }
}
