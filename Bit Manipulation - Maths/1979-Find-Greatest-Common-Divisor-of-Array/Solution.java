class Solution {
    public int findGCD(int[] nums) {
        int largest = 1;
        int smallest = 1000;

        for(int num : nums){
            if (num > largest) largest = num;
            if (num < smallest) smallest = num;
        }

        return gcd(smallest, largest);
    }

    private int gcd(int smallest, int largest){
        for(int i = smallest; i > 1; i--){
            if(smallest % i == 0 && largest % i == 0) return i;
        }

        return 1;
    }
}
