class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> Occurrences = new HashMap<>();

        for(int num : arr){
            Occurrences.put(num, Occurrences.getOrDefault(num, 0) + 1);
        }
        
        Set<Integer> uniqueValues = new HashSet<>();
        for(int value : Occurrences.values()){
            uniqueValues.add(value);
        }
        return Occurrences.size() == uniqueValues.size();
    }
}
