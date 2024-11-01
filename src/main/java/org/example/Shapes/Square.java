package org.example.Shapes;

import java.util.ArrayList;
import java.util.List;

public class Square implements Shape {
    private int label;
    private List<Square> innerSquares;

    public Square(int label) {
        this.label = label;
        this.innerSquares = new ArrayList<>();
    }

    @Override
    public String getLabel() {
        return String.valueOf(label);
    }

    public void addInnerSquare(Square square) {
        innerSquares.add(square);
    }

    public List<Square> getInnerSquares() {
        return innerSquares;
    }

    @Override
    public String toString() {
        return "Square[" + label + ", innerSquares=" + innerSquares + "]";
    }
}
