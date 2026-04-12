class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int len = nums.length;
        List<Integer> result = new ArrayList<>();
        for(int key: map.keySet()){
            if(map.get(key) > len / 3) result.add(key);
        }

        return result;
    }
}
