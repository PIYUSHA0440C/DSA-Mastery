class Solution {
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for(String word : words){
            if(isInRow(word, rows[0]) || isInRow(word, rows[1]) || isInRow(word, rows[2])){
                res.add(word);
            }
        }

        return res.toArray(new String[0]);
    }

    boolean isInRow(String word, String row){
        word = word.toLowerCase();
        for(char ch : word.toCharArray()){
            if(row.indexOf(ch) == -1) return false;
        }
        return true;
    }
}
