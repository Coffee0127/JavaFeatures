package io.github.coffee0127.java15;

public class TextBlock {

    public static void main(String[] args) {
        String json1 = """
            {
              "name": "Jack",
              "age": 18
            }
            """;

        String json2 = """
                {
                  "name": "Jack",
                  "age": 18
                }
            """;
        String json3 = """
            {
              "name": "Jack",
              "age": 18
            }
                """;

//        String json2 = "{\n" +
//                       "  \"name\": \"Jack\",\n" +
//                       "  \"age\": 18\n" +
//                       "}";
        System.out.println("json1=");
        System.out.println(json1);
        System.out.println("json2=");
        System.out.println(json2);
        System.out.println("json3=");
        System.out.println(json3);
    }

}
