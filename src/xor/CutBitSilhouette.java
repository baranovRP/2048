package xor;

public class CutBitSilhouette {

    private static int cutSilhouette(int N, int M, int i, int j) {
        int maskM = ~(M << i);
        return ~(~N & maskM);
    }

    private static int cutSilhouette2(int N, int M, int i, int j) {
        int left = (~0 << j + 1);
        int right = (1 << i) - 1;
        int mask = left | right;
        int pattern = M << i;
        return (N & mask) | pattern;
    }

    public static void main(String[] args) {
        int N = 1024, M = 19, i = 2, j = 6;
        System.out.println("Given N: " + Integer.toBinaryString(N));
        System.out.println("Put M: " + Integer.toBinaryString(M) + " beetwin i: " + i + " and j: " + j);
        System.out.println("Input : " + Integer.toBinaryString(N));
        System.out.println("Result: " + Integer.toBinaryString(cutSilhouette2(N, M, i, j)));
    }
}
