class Solution {
    public boolean equalFrequency(String word) {
        byte[] freq = new byte[26];
        for(char ch : word.toCharArray()){
            freq[ch - 'a']++;
        }

        for(byte i = 0; i < 26; i++){
            if(freq[i] == 0) continue;

            freq[i]--;
            if(isValid(freq)) return true;
            freq[i]++;
        }

        return false;
    }

    private boolean isValid(byte[] freq){
        byte expected = 0;
        for(byte num : freq){
            if (num == 0) continue;

            if (expected == 0) expected = num;
            else if (expected != num) return false;
        }

        return true;
    }
}
