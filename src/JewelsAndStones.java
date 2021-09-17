    // what are the typical input length for both jewels and stones? 
    // does jewels and stones contain only English letters? 
	// are letter case senstivies? 
	// do jewels have unique characters? 
    // time complexity O(n^2)

public class JewelsAndStones {
    public static int numJewelsInStones(String jewels, String stones) {
        int total = 0;
        for (int i = 0; i < stones.length(); i++) {
            for (int j = 0; j < jewels.length(); j++) {
                if (jewels.charAt(j) == stones.charAt(i)) total++;
            }
        }

        return total;
    }
}
