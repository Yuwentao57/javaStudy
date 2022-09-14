package algo;

/**
 * 位运算专题
 */
public class BitCalculate {
    public static void main(String[] args) {
        int a1= 0x00_00_03_00;
        // 0000_0000/0000_0000/0000_0011/0000_0000
        System.out.println(a1);
        //最后一位1的值
        int a2 = a1 & -a1;
        System.out.println(a2);
        //清空最后一位1
        int a3 = a1 & (a1 - 1);
        System.out.println(a3);








    }
}
