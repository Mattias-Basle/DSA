package algorithms.searching;

import algorithms.searching.KarpRabin;

public class Test {

    public static void main(String[] args) {
        KarpRabin kr = new KarpRabin();
        kr.search("Hello, world!", "ll");
        kr.search("Hello, world!", "worl");
        kr.search("Hello, world!", "war");
        kr.search("Hello, world!", " ");
    }
}
