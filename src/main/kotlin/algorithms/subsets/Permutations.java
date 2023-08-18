package algorithms.subsets;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        permute("", "abc");
        List<String> ans1 = permuteList("", "abc");
        System.out.println(ans1);
        List<String> ans2 = permuteListInPlace("", "abc", new ArrayList<>());
        System.out.println(ans2);
        int ans3 = permuteCount("", "abc", 0);
        System.out.println(ans3);
    }

    static void permute(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i);
            permute(first + ch + second, up.substring(1));
        }
    }

    static List<String> permuteList(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        List<String> result = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i);
            result.addAll(permuteList(first + ch + second, up.substring(1)));
        }

        return result;
    }

    static List<String> permuteListInPlace(String p, String up, List<String> result) {
        if (up.isEmpty()) {
            result.add(p);
            return result;
        }

        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i);
            permuteListInPlace(first + ch + second, up.substring(1), result);
        }

        return result;
    }

    static int permuteCount(String p, String up, int result) {
        if (up.isEmpty()) {
            result++;
            return result;
        }

        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i);
            result = permuteCount(first + ch + second, up.substring(1), result);
        }

        return result;
    }
}
