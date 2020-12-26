package io.github.coffee0127.java15;

import java.util.Objects;

public class Records {

    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p1.equals(p2));
    }
}

final record Point(int x, int y) {
    Point(int x, int y) {
        if (x < 0 || y < 0) {
            throw new java.lang.IllegalArgumentException(
                String.format("Invalid point: %d, %d", x, y));
        }
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;

        var that = (Point) obj;
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point[" + "x=" + x + ", " + "y=" + y + ']';
    }

}
