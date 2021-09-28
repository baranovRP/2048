class DefanginIpAddress {
    public String defangIPaddrRegex(String address) {
        return address.replace(".", "[.]");
    }
}
