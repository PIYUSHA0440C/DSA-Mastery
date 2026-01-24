class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> alphabets = new HashSet<>();
        for(char ch : sentence.toCharArray()){
            alphabets.add(ch);
        }
        return alphabets.size() == 26;
    }
}
