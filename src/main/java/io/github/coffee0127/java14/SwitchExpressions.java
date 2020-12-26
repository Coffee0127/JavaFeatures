package io.github.coffee0127.java14;

import static java.util.Calendar.FRIDAY;
import static java.util.Calendar.MONDAY;
import static java.util.Calendar.SATURDAY;
import static java.util.Calendar.SUNDAY;
import static java.util.Calendar.THURSDAY;
import static java.util.Calendar.TUESDAY;
import static java.util.Calendar.WEDNESDAY;

public class SwitchExpressions {
    public static void main(String[] args) {
        int day = 2;

        System.out.println(getNumLetters(day));

        int i = 0;
        String result1 = switch (i) {
            case 0 -> "Zero";
            default -> {
                String r = i % 2 == 0 ? "Even" : "Odd";
                yield r;
            }
        };
        String result2 = switch (i) {
            case 0:
                yield "Zero";
            case 1:
                yield "One";
            default:
                yield "Unknown";
        };
    }

    private static int getNumLetters(int day) {
        int numLetters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
            default -> throw new IllegalArgumentException("Not a day: " + day);
        };
        return numLetters;
    }
}
