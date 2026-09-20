class Solution {
    public char repeatedCharacter(String s) {
        boolean[] seen = new boolean[26];

        for(char ch : s.toCharArray()) {
            if(seen[ch - 'a']) return ch;
            seen[ch - 'a'] = true;
        }

        return ' ';
    }
}

