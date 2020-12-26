package io.github.coffee0127.java15;

public class PatternMatching {
    public static void main(String[] args) {
        Object obj = null;

        legacyInstanceof(obj);
    }

    private static void legacyInstanceof(Object obj) {
        if (obj instanceof String) {
            String s = (String) obj;
            if (s.length() > 1) {
                System.out.println(s.toUpperCase());
            }
        }
    }

    private static void newInstanceof(Object obj) {
        if (obj instanceof String s && s.length() > 1) {
            System.out.println(s.toUpperCase());
        }
    }
}
