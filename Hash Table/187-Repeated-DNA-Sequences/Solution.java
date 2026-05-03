class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        if(len < 10) return new ArrayList<>();

        Set<String> seen = new HashSet<>();
        Set<String> res = new HashSet<>();

        for(int i = 0; i <= len - 10; i++){
            String str = s.substring(i, i + 10);

            if(!seen.add(str)) res.add(str);
        }

        return new ArrayList<>(res);
    }
}
