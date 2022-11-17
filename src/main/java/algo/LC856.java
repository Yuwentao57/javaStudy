package algo;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC856 {
    public static void main(String[] args) {
        Solution856 solution856 = new Solution856();
        String s1 = "()";
        String s2 = "()()";
        String s3 = "(())";
        String s4 = "(()())";

        System.out.println(solution856.scoreOfParentheses(s1));
        System.out.println(solution856.scoreOfParentheses(s2));
        System.out.println(solution856.scoreOfParentheses(s3));
        System.out.println(solution856.scoreOfParentheses(s4));

    }
}


class Solution856 {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sum;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(0);
            } else {
                sum = 0;
                while (!stack.isEmpty() && stack.peekLast() != 0) {
                    sum += stack.removeLast();
                }
                stack.removeLast();
                stack.add(sum == 0 ? 1 : 2 * sum);
            }
        }
        sum = 0;
        for (Integer ele: stack) {
          sum += ele;
        }
        return sum;
    }
}