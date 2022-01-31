package xor;

public class BitwiseOps {

    static boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0);
    }

    static int setBit(int num, int i) {
        return num | (1 << i);
    }

    static int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }

    static int clearBitsMSBthroughI(int num, int i) {
        int mask = (1 << i) - 1;
        return num & mask;
    }

    static int clearBitsMSBthrough0(int num, int i) {
        int mask = ~(-1 >>> 32-i);
        return num & mask;
    }

    static int updateBit(int num, int i, boolean bitIs1) {
        int value = bitIs1 ? 1 : 0;
        int mask = ~(1 << i);
        return (num & mask) | (value << i);
    }

    public static void main(String[] args) {
        System.out.println("Check if i-bit is 1 : "
                + Integer.toBinaryString(11) + " : " + getBit(11, 1));
        System.out.println(Integer.toBinaryString(9)
                + " :" + " set i-bit to 1 : " + Integer.toBinaryString(setBit(9, 1)));
        System.out.println(Integer.toBinaryString(10)
                + " :" + " clear i-bit to 0 : " + Integer.toBinaryString(clearBit(10, 1)));
        System.out.println(Integer.toBinaryString(11)
                + " :" + " clear bits before i  : " + Integer.toBinaryString(clearBitsMSBthroughI(11, 2)));
        System.out.println(Integer.toBinaryString(12)
                + " :" + " clear bits after i : " + Integer.toBinaryString(clearBitsMSBthrough0(12, 2)));
        System.out.println(Integer.toBinaryString(12)
                + " :" + " set i-bit to given value (1 or 0) : "
                + Integer.toBinaryString(updateBit(12, 2, false)));
    }

}
