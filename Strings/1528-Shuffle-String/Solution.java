class Solution {
    public String restoreString(String s, int[] indices) {
        // StringBuilder sb = new StringBuilder();
        int len = indices.length;
        char[] ch = new char[len];
        for(int i = 0; i < len; i++){
            int charIndex = indices[i];
            ch[charIndex] = s.charAt(i);
        }
        // return new String(ch);
        return String.valueOf(ch);
        // return Arrays.toString(ch);
    }
}
