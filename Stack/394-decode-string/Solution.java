class Solution {

    private int index;
    public String decodeString(String s) {
        index = 0;
        return decode(s);
    }

    private String decode(String s) {
        StringBuilder res = new StringBuilder();

        int num = 0;
        int len = s.length();

        while (index < len) {
            char ch = s.charAt(index);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
                index++;

            } else if (ch == '[') {
                index++;
                String inner = decode(s);
                for (int k = 0; k < num; k++) res.append(inner);
                num = 0;

            } else if (ch == ']') {
                index++;
                return res.toString();

            } else {
                res.append(ch);
                index++;
            }
        }

        return res.toString();
    }
}
