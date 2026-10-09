class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int leftCount = 0;
        int length = s.length();
        int index = 0;

        while(index < length){
            char ch = s.charAt(index);

            if (ch == '(') leftCount++;
            else {
                if (leftCount > 0) leftCount--;
                else insertions++;

                if (index < length - 1 && s.charAt(index + 1) == ')') index++;
                else insertions++;
            }

            index++;
        }

        insertions += leftCount * 2;

        return insertions;
    }
}
