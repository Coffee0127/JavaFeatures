package io.github.coffee0127.java15;

public class SealedClasses {

    public sealed interface Shape
        // The permits clause could be omitted if its permitted
        // classes have been defined in the same file.
        permits Circle, Rectangle, Square, Triangle {
    }

    public record Triangle(int base, int height) implements Shape {
    }

    public final class Circle implements Shape {
        public float radius;
    }

    public non-sealed class Square implements Shape {
        public double side;
    }

    public sealed class Rectangle implements Shape permits FilledRectangle {
        public double length, width;
    }

    public final class FilledRectangle extends Rectangle {
        public int red, green, blue;
    }

/*

    // This code doesn't work in Java 15.
    // It would work in a future Java version after the addition of
    // type-test-pattern to the switch expressions
    public int getCenter(Shape shape) {
        return switch (shape) {
            case Circle
                c -> c.hashCode();
            case Square
                s -> s.side;
            case Triangle
                t -> t.base() / 2;
            case Rectangle
                r -> 0;
        };
    }
*/
}
