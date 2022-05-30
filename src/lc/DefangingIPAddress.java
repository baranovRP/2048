package lc;

public class DefangingIPAddress {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public String defangIPaddr1(String address) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.')
                sb.append("[.]");
            else
                sb.append(address.charAt(i));
        }

        return sb.toString();
    }
}
