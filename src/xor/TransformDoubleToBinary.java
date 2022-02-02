package xor;

public class TransformDoubleToBinary {

    private static String printBinary(double num) {
        if (num >= 1 || num <= 0) return "ERROR";

        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while (num > 0) {
            if (binary.length() >= 32) return "ERROR";

            double r = num * 2;
            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        double d = 0.78;
        System.out.println("Double to Integer: " + d + " to " + printBinary(d));
    }

}
