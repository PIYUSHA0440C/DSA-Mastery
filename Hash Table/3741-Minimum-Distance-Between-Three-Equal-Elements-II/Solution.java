class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int val = nums[i];
            if(!map.containsKey(val)){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(val, list);
            } else {
                map.get(val).add(i);
            }
        }

        int result = Integer.MAX_VALUE;
        for(int key: map.keySet()){
            List<Integer> list = map.get(key);
            if(list.size() < 3) continue;

            for(int i = 0; i <= list.size() - 3; i++){
                result = Math.min(result, 2*(list.get(i+2) - list.get(i)));
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
