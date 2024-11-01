package org.example;

import org.example.Shapes.Shape;
import org.example.Shapes.ShapeParser;

public class Main {
    public static void main(String[] args) {
        String input = "[12](BALL(INK[1[35]](CHARLIE)))";
        try {
            System.out.println("Parsing input: " + input);
            ShapeParser parser = new ShapeParser(input);
            parser.parseAndDescribe();  // Call the
        } catch (Exception e) {
            System.out.println("Parsing failed: " + e.getMessage());
        }
    }
}