class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int temp = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                temp += accounts[i][j];
            }
            max = max < temp ? temp : max;
        }
        return max;
    }

    public int maximumWealth2(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int temp = 0;
            for (int i : account) {
                temp += i;
            }
            max = Math.max(max, temp);
        }
        return max;
    }
}