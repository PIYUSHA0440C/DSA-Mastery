class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        int n = candyType.length / 2;
        int count = 0;
        
        for(int num : candyType){
            if (set.add(num) && n-- > 0) count++;
            if(n <= 0) break;
        }
        return count;
    }
}
