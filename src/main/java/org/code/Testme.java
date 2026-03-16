package org.code;

public class Testme {
    public static void main(String[] args) {
        printItem("hello");
        printItem(12);
        printItem(12.1f);
        printItem(12.2f);
    }

    private static <T> void printItem(T item) {
        System.out.println(item.toString());
    }
}