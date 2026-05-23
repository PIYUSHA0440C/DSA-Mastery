class Solution {
    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        int[] ans = new int[len];
        int j = 0;

        for(int i = 0; i < len && j < len; i++){
            ans[j++] = arr[i];

            if(arr[i] == 0 && j < len) ans[j++] = 0;
        }

        for(int i = 0; i < len; i++) arr[i] = ans[i];
    }
}

