package io.github.coffee0127.java10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiFunction;

public class LocalVariable {

    public static void main(String[] args) throws Exception {
        var url = new URL("http://www.oracle.com/");
        var conn = url.openConnection();
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(conn.getInputStream()));

        URI fileName = null;

        // Local variable declarations with initializers
        var list = new ArrayList<String>();    // infers ArrayList<String>
        var stream = list.stream();            // infers Stream<String>
        var path = Paths.get(fileName);        // infers Path
        var bytes = Files.readAllBytes(path);  // infers bytes[]

        // Enhanced for-loop indexes
        var myList = Arrays.asList("a", "b", "c");
        for (var element : myList) { /* */ }  // infers String

        // Index variables declared in traditional for loops
        for (var counter = 0; counter < 10; counter++) { /* */ }   // infers int

        // try-with-resources variable
        try (var input = new FileInputStream("validation.txt")) { /* */ }   // infers FileInputStream

        // lambda expression variable
        BiFunction<Integer, Integer, Integer> biFunction = (var a, var b) -> a + b;

    }

    // ORIGINAL
    void removeMatches(Map<? extends String, ? extends Number> map, int max) {
        for (Iterator<? extends Map.Entry<? extends String, ? extends Number>> iterator =
             map.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<? extends String, ? extends Number> entry = iterator.next();
            if (max > 0 && matches(entry)) {
                iterator.remove();
                max--;
            }
        }
    }

    // GOOD
    void removeMatches2(Map<? extends String, ? extends Number> map, int max) {
        for (var iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            var entry = iterator.next();
            if (max > 0 && matches(entry)) {
                iterator.remove();
                max--;
            }
        }
    }

    String readLine(Socket socket, Charset charsetName) throws IOException {
        // ORIGINAL
        try (InputStream is = socket.getInputStream();
             InputStreamReader isr = new InputStreamReader(is, charsetName);
             BufferedReader buf = new BufferedReader(isr)) {
            return buf.readLine();
        }
    }

    String readLine2(Socket socket, Charset charsetName) throws IOException {
        // GOOD
        try (var inputStream = socket.getInputStream();
             var reader = new InputStreamReader(inputStream, charsetName);
             var bufReader = new BufferedReader(reader)) {
            return bufReader.readLine();
        }
    }

    private boolean matches(Map.Entry<? extends String, ? extends Number> entry) {
        return false;
    }
}
