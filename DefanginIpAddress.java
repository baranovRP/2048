class DefanginIpAddress {

    public String defangIPaddr(String address) {

       String [] splitted = address.split("."); 

    StringBuffer sb = new StringBuffer();

    for (String s : splitted) {

        s.append("[.]")

    }

        return sb.toString();

    }

}
