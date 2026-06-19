class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int altitude = 0;

        for(int num : gain){
            altitude += num;
            maxAltitude = Math.max(maxAltitude, altitude);
        }

        return maxAltitude;
    }
}

