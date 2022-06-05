package lc;

public class RobotReturnOrigin {

    // Time = O(N)
    // Space = O(1)
    public boolean judgeCircle(String moves) {
        if (moves.length() % 2 != 0) return false;
        int upDown = 0, leftRight = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U') upDown++;
            else if (moves.charAt(i) == 'D') upDown--;
            else if (moves.charAt(i) == 'L') leftRight++;
            else if (moves.charAt(i) == 'R') leftRight--;
        }
        return upDown == 0 && leftRight == 0;
    }
}
