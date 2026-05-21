class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;

        for(int num : arr1){
            while(num > 0){
                set.add(num);
                num /= 10;
            }
        }

        for(int num : arr2){
            while(num > 0){
                if(set.contains(num)) ans = Math.max(ans, length(num));
                num /= 10;
            }
        }

        return ans;
    }

    private int length(int num){
        int ans = 0;
        while(num > 0){
            ans++;
            num /= 10;
        }

        return ans;
    }
}
