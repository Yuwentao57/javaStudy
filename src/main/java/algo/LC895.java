package algo;

import java.util.*;

public class LC895 {
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());

    }
}

class FreqStack {
    List<Integer> stack = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    public FreqStack() {
    }

    public void push(int val) {
        stack.add(val);
        map.put(val,map.getOrDefault(val, 0) + 1);
        int t = map.get(val);
        list.add(t);
        int i = list.size() - 1;
        for (; i > 0; i--) {
            if (t < list.get(i - 1)) {
                list.set(i, list.get(i - 1));
            } else {
                break;
            }
        }
        list.set(i, t);
    }

    public int pop() {
        int t = list.remove(list.size() - 1);
        int ans = stack.get(0);
        for (int i = stack.size() - 1; i >=0 ; --i) {
            int fre = map.get(stack.get(i));
            if (fre == t) {
                map.put(stack.get(i), fre - 1);
                return stack.remove(i);
            }
        }
        return ans;
    }
}