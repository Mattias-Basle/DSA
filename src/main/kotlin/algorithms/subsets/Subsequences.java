package algorithms.subsets;

import java.util.*;

public class Subsequences {

    public static void main(String[] args) {
        String sequence = "abc";

        List<String> result1 = processIteration(sequence);
        System.out.println(result1);

        List<String> result2 = processHybrib(sequence, new ArrayList<>());
        System.out.println(result2);

        processRecursion("", sequence);
    }

    static List<String> processIteration(String seq) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < seq.length(); i++) {
            String current = "";
            for (int j = i; j < seq.length(); j++) {
                current += seq.charAt(j);
                result.add(current);
            }
        }

        return result;
    }

    static List<String> processHybrib(String seq, List<String> subs) {
        if (seq.isEmpty()) {
            return subs;
        }
        String current = "";

        for (int i = 0; i < seq.length(); i++) {
            current += seq.charAt(i);
            subs.add(current);
        }

        processHybrib(seq.substring(1), subs);

        return subs;
    }

    static void processRecursion(String process, String seq) {
        if (seq.isEmpty()) {
            System.out.print(process + " ");
            return;
        }

        char ch = seq.charAt(0);

        processRecursion(process + ch, seq.substring(1));
        processRecursion(process, seq.substring(1));
    }
}
