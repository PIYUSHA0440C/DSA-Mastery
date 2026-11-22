class Solution {
    public boolean checkString(String s) {
        int index = 0;
        int len = s.length();
        while (index < len && s.charAt(index) != 'b') index++;

        while (index < len) {
            if (s.charAt(index) == 'a') return false;
            index++;
        }

        return true;
    }
}
