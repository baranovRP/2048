package ds.stack_queue;

public class FindCelebChallenge {

    public static int findCelebrity(int[][] party, int numPeople) {
        int celebrity = -1;
        Stack<Integer> guests = new Stack<>(4);
        for (int i = numPeople - 1; i >= 0; i--) guests.push(i);
        while (guests.getCurrentSize() != 1) {
            int first = guests.pop();
            int second = guests.pop();
            boolean status = aqStatus(party, first, second);
            if (status) guests.push(second);
            else guests.push(first);
        }
        celebrity = guests.pop();
        for (int i = 0; i < numPeople; i++) {
            if (party[celebrity][i] == 1) return -1;
        }
        return celebrity;
    }

    private static boolean aqStatus(int[][] party, int first, int second) {
        return party[first][second] == 1;
    }

    //returns true if x knows y else returns false
    private static boolean aqStatus1(int[][] party, int x, int y) {
        if (party[x][y] == 1) return true;
        return false;
    }

    //  Time = O(n).
    public static int findCelebrity1(int[][] party, int numPeople) {
        Stack<Integer> stack = new Stack<>(numPeople);
        int celebrity = -1;

        //Push all people in stack
        for (int i = 0; i < numPeople; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {

            //Take two people out of stack and check if they know each other
            //One who doesn't know the other, push it back in stack.
            int x = stack.pop();

            if (stack.isEmpty()) {
                celebrity = x;
                break;
            }

            int y = stack.pop();

            if (aqStatus(party, x, y)) {
                //x knows y , discard x and push y in stack
                stack.push(y);
            } else stack.push(x);

        } //end of while

        //At this point we will have last element of stack as celebrity
        //Check it to make sure it's the right celebrity
        for (int j = 0; j < numPeople; j++) {

            //Celebrity knows no one while everyone knows celebrity
            if (celebrity != j && (aqStatus(party, celebrity, j) || !(aqStatus(party, j, celebrity)))) return -1;
        }
        return celebrity;
    }//end of findCelebrity()

    public static void main(String args[]) {

        int [][] party1 = {
                {0,1,1,0},
                {1,0,1,1},
                {0,0,0,0},
                {0,1,1,0},
        };

        int [][] party2 = {
                {0,1,1,0},
                {1,0,1,1},
                {0,0,0,1},
                {0,1,1,0},
        };

        int [][] party3 = {
                {0,0,0,0},
                {1,0,0,1},
                {1,0,0,1},
                {1,1,1,0},
        };

        System.out.println(findCelebrity1(party1,4));
        System.out.println(findCelebrity(party2,4));
        System.out.println(findCelebrity(party3,4));
    }
}
