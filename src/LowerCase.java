class LowerCase {
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }

//    For Latin alphabet
    public String toLowerCase2(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = (char)(str.charAt(i) | (char)(32));
            sb.append(c);
        }
        return sb.toString();
    }
}