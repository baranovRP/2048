package lc;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int[] nominals = new int[]{0, 0, 0};
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 20) {
                if (nominals[1] >= 1 && nominals[0] >= 1) {
                    nominals[1] -= 1;
                    nominals[0] -= 1;
                    nominals[2] += 1;
                } else if (nominals[0] >= 3) {
                    nominals[0] -= 3;
                } else {
                    return false;
                }
            } else if (bills[i] == 10) {
                if (nominals[0] >= 1) {
                    nominals[0] -= 1;
                    nominals[1] += 1;
                } else {
                    return false;
                }
            } else {
                nominals[0] += 1;
            }
        }
        return true;
    }

    // Time = O(N)
    // Space = O(1)
    public boolean lemonadeChange1(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5)
                five++;
            else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
