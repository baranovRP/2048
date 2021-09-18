public class RemoveVowelsFromString {
    public String removeVowels(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char symb = S.charAt(i);
            if (isVowel(symb)) {
                continue;
            }
            sb.append(symb);
        }
        return sb.toString();
    }

    private boolean isVowel(char symb) {
        return symb == 'a' || symb == 'e' || symb == 'i' || symb == 'o' || symb == 'u';
    }
}
