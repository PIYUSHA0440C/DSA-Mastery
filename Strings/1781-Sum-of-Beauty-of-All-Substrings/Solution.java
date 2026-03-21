class Solution {
    public int beautySum(String s) {
        int len = s.length();
        int sum = 0;

        for(int i = 0; i < len; i++){
            HashMap<Character, Integer> freq = new HashMap<>();

            for(int j = i; j < len; j++){
                freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);

                int maxInt = Integer.MIN_VALUE;
                int minInt = Integer.MAX_VALUE;

                for(int val : freq.values()){
                    minInt = Math.min(minInt, val);
                    maxInt = Math.max(maxInt, val);
                }

                sum += (maxInt - minInt);
            }
        }

        return sum;
    }
}
