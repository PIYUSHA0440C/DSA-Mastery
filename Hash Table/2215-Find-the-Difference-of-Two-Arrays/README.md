# 2215. Find the Difference of Two Arrays (Easy)

## 📝 Problem Statement
Given two integer arrays `nums1` and `nums2`, return a list of size `2` where:

- `answer[0]` contains all **distinct integers** in `nums1` that are **not present** in `nums2`.
- `answer[1]` contains all **distinct integers** in `nums2` that are **not present** in `nums1`.

The integers in the resulting lists may be returned in any order.

## 💡 Intuition & Approach
The main challenge is to find the distinct elements that exist in one array but are completely absent from the other array.

We use two **HashSets** to store the unique elements of both arrays. Since a HashSet does not allow duplicate values, it automatically handles the requirement that each integer should appear only once in the result.

We then compare both sets:
1. Iterate through `set1` and check whether each element exists in `set2`.
2. If it does not exist, add it to the first result list.
3. Iterate through `set2` and check whether each element exists in `set1`.
4. If it does not exist, add it to the second result list.

### 🛠️ The Strategy:
1. Create two `HashSet<Integer>` objects.
2. Add all elements of `nums1` to `set1`.
3. Add all elements of `nums2` to `set2`.
4. Traverse `set1` and collect elements not present in `set2`.
5. Traverse `set2` and collect elements not present in `set1`.
6. Return both result lists.

## 📊 Complexity Analysis
* **Time Complexity:** O(n + m) - Building the two HashSets and performing the membership checks takes O(n + m) average time, where `n` and `m` are the lengths of the two arrays.
* **Space Complexity:** O(n + m) - The two HashSets store the distinct elements from both arrays.

## 💻 Implementation (Java)
```java
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        
        for(int num: nums1) set1.add(num);
        for(int num: nums2) set2.add(num);

        for(int num: set1) {
            if(!set2.contains(num)) ans.get(0).add(num);
        }

        for(int num: set2){
            if(!set1.contains(num)) ans.get(1).add(num);
        }

        return ans;
    }
}
