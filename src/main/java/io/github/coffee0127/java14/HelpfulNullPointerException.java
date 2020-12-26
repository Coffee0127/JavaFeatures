package io.github.coffee0127.java14;

public class HelpfulNullPointerException {

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.b.c.d);
    }

}

class A {
    B b = new B();
}

class B {
    C c;
}

class C {
    D d;
}

class D {
    int foo;
}
