package lc;

public class RemoveVowelsFromString {

    public String removeVowels(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (isConsonat(letter)) {
                sb.append(letter);
            }
        }
        return sb.toString();
    }

    private boolean isConsonat(char letter) {
        return letter != 'a' && letter != 'e' && letter != 'i' && letter != 'o' && letter != 'u';
    }
}
