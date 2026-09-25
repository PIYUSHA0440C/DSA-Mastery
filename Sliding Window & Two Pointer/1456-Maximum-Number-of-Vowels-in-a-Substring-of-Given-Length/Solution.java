class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        for(int i = 0; i < k; i++){
            if(isVowel(s.charAt(i))) count++;
        }

        int maxAns = count;

        for(int i = k; i < s.length(); i++){
            if(isVowel(s.charAt(i))) count++;
            if(isVowel(s.charAt(i - k))) count--;

            maxAns = Math.max(maxAns, count);
        }

        return maxAns;        
    }

    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
