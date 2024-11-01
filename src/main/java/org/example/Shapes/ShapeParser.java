package org.example.Shapes;

public class ShapeParser {
    private String input;
    private int index;

    public ShapeParser(String input) {
        this.input = input;
        this.index = 0;
    }

    public void parseAndDescribe() throws Exception {
        while (index < input.length()) {
            if (input.charAt(index) == '[') {
                parseSquareAndDescribe();
            } else if (input.charAt(index) == '(') {
                parseCircleAndDescribe();
            } else {
                throw new Exception("Invalid character at index " + index + ": " + input.charAt(index));
            }
        }
    }

    private void parseSquareAndDescribe() throws Exception {
        expect('[');
        int label = parseNumber();
        System.out.println("A square: [" + label + "]");

        // Recursively parse any inner squares
        while (input.charAt(index) != ']') {
            parseSquareAndDescribe();
        }
        expect(']');
    }

    private void parseCircleAndDescribe() throws Exception {
        expect('(');
        String label = parseLabel();
        System.out.println("A circle: (" + label + ")");

        // Recursively parse any inner shapes
        while (input.charAt(index) != ')') {
            if (input.charAt(index) == '[') {
                parseSquareAndDescribe();
            } else if (input.charAt(index) == '(') {
                parseCircleAndDescribe();
            } else {
                throw new Exception("Invalid inner shape inside circle at index " + index);
            }
        }
        expect(')');
    }

    private void expect(char c) throws Exception {
        if (input.charAt(index) != c) {
            throw new Exception("Expected '" + c + "' but found '" + input.charAt(index) + "' at index " + index);
        }
        index++;
    }

    private int parseNumber() throws Exception {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(input.charAt(index))) {
            sb.append(input.charAt(index));
            index++;
        }
        if (sb.length() == 0) {
            throw new Exception("Expected a numeric label for square but found: " + input.charAt(index) + " at index " + index);
        }
        return Integer.parseInt(sb.toString());
    }

    private String parseLabel() throws Exception {
        StringBuilder sb = new StringBuilder();
        while (Character.isUpperCase(input.charAt(index))) {
            sb.append(input.charAt(index));
            index++;
        }
        if (sb.length() == 0) {
            throw new Exception("Expected an uppercase label for circle but found: " + input.charAt(index) + " at index " + index);
        }
        return sb.toString();
    }
}
