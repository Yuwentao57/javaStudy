package talgo;

import java.util.Stack;

/**
 * @Description TODO
 */
public class JZ09 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        System.out.println(solution.pop());
        System.out.println(solution.pop());
    }

    static class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack2.size() < 1) {
                while (stack1.size() > 0) {
                    stack2.push(stack1.pop());
                }
                stack1.clear();
            }
            return stack2.pop();
        }
    }
}
