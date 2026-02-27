class Solution {
    public String reversePrefix(String word, char ch) {
        int end = word.indexOf(ch);

        if (end == -1 || end == 0) {
            return word;
        }

        char[] chars = word.toCharArray();
        int start = 0;
        while (start <= end) {
            char tmp = chars[end];
            chars[end] = chars[start];
            chars[start] = tmp;

            start++;
            end--;
        }

        return new String(chars);
    }
}
