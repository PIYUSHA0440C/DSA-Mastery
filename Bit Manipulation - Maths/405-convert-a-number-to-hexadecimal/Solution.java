class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";

        char[] hexMap = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            int lastFourBits = num & 15;
            sb.append(hexMap[lastFourBits]);

            num >>>= 4;
        }

        return sb.reverse().toString();
    }
}
