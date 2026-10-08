class Solution {
    public int minSwaps(String s) {
        int stackSize = 0;
        int unbalanced = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if (ch == '[') stackSize++;
            else {
                if (stackSize > 0) stackSize--;
                else unbalanced++;
            }
        }

        return (unbalanced + 1) / 2;
    }
}
