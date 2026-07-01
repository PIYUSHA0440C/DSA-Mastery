class Solution {
    public int strStr(String str, String pattern) {
        int n = str.length(), m = pattern.length();


        int[] lps = new int[m];
        int prevLPSLen = 0, cur = 1;

        while (cur < m) {
            if (pattern.charAt(prevLPSLen) == pattern.charAt(cur)) {
                lps[cur++] = ++prevLPSLen;
            } else {
                if (prevLPSLen == 0) {
                    lps[cur++] = 0;
                } else {
                    prevLPSLen = lps[prevLPSLen - 1];
                }
            }
        }


        int i = 0, j = 0;
        while (i < n && j < m) {
            if (str.charAt(i) == pattern.charAt(j)) {
                i++; j++;
            } else {
                if (j == 0) i++;
                else j = lps[j - 1];
            }
        }

        return (j == m) ? (i - j) : -1;
    }
}
