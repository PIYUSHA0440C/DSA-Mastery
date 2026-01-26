# 33. Search in Rotated Sorted Array (Medium)

## 📝 Problem Statement
An integer array `nums` is sorted in ascending order with distinct values. Prior to being passed to your function, it might be rotated at an unknown pivot index. 

For example, `[4,5,6,7,0,1,2]` is a rotated version of `[0,1,2,4,5,6,7]`.

Given the rotated array and a `target`, return the index of `target` if it is in `nums`, or `-1` if it is not.
**Requirement:** Algorithm must run in **O(log n)** time complexity.



## 💡 Intuition & Approach
A rotated sorted array is composed of two sorted ascending subarrays. To maintain $O(\log n)$ efficiency, we can't search linearly. Instead, we find the "point of rotation."

1. **Find the Pivot:** I implemented a `pivot()` method. The pivot is the largest element. It’s the only place in the array where `nums[i] > nums[i+1]`.
2. **Handle the Pivot cases:**
   - If `nums[mid] > nums[mid+1]`, `mid` is the pivot.
   - If `nums[mid] < nums[mid-1]`, `mid-1` is the pivot.
3. **Determine Search Range:**
   - If the array isn't rotated (pivot is -1), search the whole array.
   - If `target >= nums[start]`, the target is in the first sorted part (from `start` to `pivot`).
   - Otherwise, the target is in the second sorted part (from `pivot+1` to `end`).
4. **Binary Search:** Execute a standard binary search on the identified range.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝙡𝙤𝙜 𝙣) - One pass to find the pivot and one pass to find the target.
* **Space Complexity:** 𝙊(𝟭) - No extra data structures used.

## 💻 Implementation (Java)
```java
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        int pivot = pivot(nums, start, end);
        
        // If no pivot found, array is not rotated
        if(pivot == -1){
            return binarySearch(nums, target, start, end);
        }
        
        if(nums[pivot] == target){
            return pivot;
        }
        
        // Target is in the first half
        if(target >= nums[start]){
            return binarySearch(nums, target, start, pivot);
        }
        
        // Target is in the second half
        return binarySearch(nums, target, pivot + 1, end);
    }

    int binarySearch(int[] nums, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) start = mid + 1;
            else if (target < nums[mid]) end = mid - 1;
            else return mid;
        }
        return -1;
    }

    int pivot(int[] nums, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            if(mid < end && nums[mid] > nums[mid+1]){
                return mid;
            }
            if(mid > start && nums[mid] < nums[mid-1]){
                return mid - 1;
            }
            
            if(nums[mid] <= nums[start]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
