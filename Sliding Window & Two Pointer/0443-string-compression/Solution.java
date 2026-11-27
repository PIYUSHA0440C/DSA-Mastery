class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int len = chars.length;
        int currIndex = 0;

        while (index < len) {
            int count = 0;
            char ch = chars[index];

            while (index < len && chars[index] == ch) {
                count++;
                index++;
            }
            
            chars[currIndex++] = ch;

            if (count > 1) {
                for (char digit: Integer.toString(count).toCharArray()) {
                    chars[currIndex++] = digit;
                }
            }
        }

        return currIndex;
    }
}
