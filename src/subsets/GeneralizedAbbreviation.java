package subsets;

import java.util.*;

class AbbreviatedWord {
    StringBuilder str;
    int start;
    int count;

    public AbbreviatedWord(StringBuilder str, int start, int count) {
        this.str = str;
        this.start = start;
        this.count = count;
    }
}

class GeneralizedAbbreviation {

    /**
     * Time complexity
     * Since we had two options for each character, we will have a maximum of 2^N combinations.
     * If you see the visual representation of Example-1 closely,
     * you will realize that it is equivalent to a binary tree, where each node has two children.
     * This means that we will have 2^N nodes and 2^N-1 intermediate nodes,
     * so the total number of elements pushed to the queue will be 2^N+2^N-1,
     * which is asymptotically equivalent to O(2^N).
     * While processing each element, we do need to concatenate the current string with a character.
     * This operation will take O(N), so the overall time complexity of our algorithm will be O(N*2^N).
     * <p>
     * Space complexity
     * All the additional space used by our algorithm is for the output list.
     * Since we can’t have more than O(2^N) combinations, the space complexity of our algorithm is O(N*2^N).
     */
    public static List<String> generateGeneralizedAbbreviation(String word) {
        int wordLen = word.length();
        List<String> result = new ArrayList<>();
        Queue<AbbreviatedWord> queue = new LinkedList<>();
        queue.add(new AbbreviatedWord(new StringBuilder(), 0, 0));
        while (!queue.isEmpty()) {
            AbbreviatedWord abWord = queue.poll();
            if (abWord.start == wordLen) {
                if (abWord.count != 0)
                    abWord.str.append(abWord.count);
                result.add(abWord.str.toString());
            } else {
                // continue abbreviating by incrementing the current abbreviation count
                queue.add(new AbbreviatedWord(new StringBuilder(abWord.str), abWord.start + 1, abWord.count + 1));

                // restart abbreviating, append the count and the current character to the string
                if (abWord.count != 0)
                    abWord.str.append(abWord.count);
                queue.add(
                        new AbbreviatedWord(new StringBuilder(abWord.str).append(word.charAt(abWord.start)), abWord.start + 1, 0));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);

        result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("code");
        System.out.println("Generalized abbreviation are: " + result);
    }
}
