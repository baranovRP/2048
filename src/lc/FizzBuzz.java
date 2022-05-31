package lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FizzBuzz {

    // Time = O(N)
    // Space = O(1)
    public List<String> fizzBuzz(int n) {
        List<String> answers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String answer = "";
            if (i % 3 == 0) answer += "Fizz";
            if (i % 5 == 0) answer += "Buzz";
            if (i % 3 != 0 && i % 5 != 0) answer += i;
            answers.add(answer);
        }
        return answers;
    }

    /*
    Having a condition for every mapping is not feasible,
    or maybe we can say the code might get ugly and tough to maintain.
    What if tomorrow we have to change a mapping, or maybe delete a mapping?
    Are we going to change the code every time we have a modification in the mappings?
     */
    // Time = O(N)
    // Space = O(1)
    public List<String> fizzBuzzHash(int n) {
        // ans list
        List<String> ans = new ArrayList<>();

        // Hash map to store all fizzbuzz mappings.
        HashMap<Integer, String> fizzBizzDict = new HashMap<>() {
            {
                put(3, "Fizz");
                put(5, "Buzz");
            }
        };

        for (int num = 1; num <= n; num++) {
            String numAnsStr = "";
            for (Integer key : fizzBizzDict.keySet()) {

                // If the num is divisible by key,
                // then add the corresponding string mapping to current numAnsStr
                if (num % key == 0) {
                    numAnsStr += fizzBizzDict.get(key);
                }
            }

            if (numAnsStr.equals("")) {
                // Not divisible by 3 or 5, add the number
                numAnsStr += Integer.toString(num);
            }

            // Append the current answer str to the ans list
            ans.add(numAnsStr);
        }

        return ans;
    }
}
