class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        for(int num : nums1){
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums2){
            if(map1.containsKey(num) && map1.get(num) > 0) list.add(num);
            map2.put(num, map2.get(num) - 1);
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i);
        }

        return result;
    }
}

