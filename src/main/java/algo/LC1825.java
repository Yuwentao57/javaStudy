package algo;

import java.util.*;

public class LC1825 {
    public static void main(String[] args) {
        MKAverage mkAverage = new MKAverage(3, 1);
        mkAverage.addElement(3);
        mkAverage.addElement(1);
        mkAverage.calculateMKAverage();
        mkAverage.addElement(10);
        System.out.println(mkAverage.calculateMKAverage());
    }

}

class MKAverage {
    int sizeM;
    int sizeK;

    int suma;
    int sums;
    int sumb;
    int acc;

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> big;

    TreeMap<Integer, Integer> map;


    public MKAverage(int m, int k) {
        sizeM = m;
        sizeK = k;
        small = new PriorityQueue<>(k);
        map = new TreeMap<>();
        big = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addElement(int num) {
        if (acc < sizeM) {
            acc += 1;
            if (small.size() < sizeK) {
                small.add(num);
                big.add(num);
            } else {
                if (big.peek() > num) {
                    int t = big.remove();
                    big.add(num);
                    map.put(t, map.getOrDefault(t, 0) + 1);
                } else {

                }
            }
        } else {

        }
    }

    public int calculateMKAverage() {
        return (suma - sums - sumb) / (sizeM - sizeK * 2);
    }
}