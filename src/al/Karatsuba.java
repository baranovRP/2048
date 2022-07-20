package al;

public class Karatsuba {

    private Long mult(long i, long j) {
        int len1 = numLength(i);
        int len2 = numLength(j);
        if (len1 <= 1) return i * j;

        int maxLength = Math.max(len1, len2);
        Integer halfMaxLength = maxLength / 2 + maxLength % 2;
        long maxNumLength10 = (long) Math.pow(10, halfMaxLength);

        long a = i / maxNumLength10, b = i % maxNumLength10;
        long c = j / maxNumLength10, d = j % maxNumLength10;

        long p = a + b, q = c + d;

        long ac = mult(a, c), bd = mult(b, d), pq = mult(p, q);

        long abcd = pq - ac - bd;

        return ac * (long) Math.pow(10, maxLength)
                + abcd * (long) Math.pow(10, maxLength / 2)
                + bd;
    }

    private int numLength(long num) {
        int len = 0;
        while (num > 0) {
            num /= 10;
            len++;
        }
        return len;
    }


    public static void main(String[] args) {
        Karatsuba k = new Karatsuba();
        System.out.println("56016 == " + k.mult(2334L, 24L));
        System.out.println("446101345250880049 == " + k.mult(Integer.MAX_VALUE,
                Integer.MAX_VALUE));
    }
}
