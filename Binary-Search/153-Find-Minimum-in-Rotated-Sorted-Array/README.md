# 153. Find Minimum in Rotated Sorted Array (Medium)

## 📝 Problem Statement
Suppose an array of length `n` sorted in ascending order is rotated between `1` and `n` times. Given the sorted rotated array `nums` of unique elements, return the minimum element of this array.

**Requirement:** You must write an algorithm that runs in **O(log n)** time.



## 💡 Intuition & Approach
In a sorted array that has been rotated, the minimum element is the only element that is smaller than its predecessor. This "inflection point" is where the rotation happened.

1. **Leveraging the Pivot:** I reused the pivot-finding logic. In a rotated sorted array, the "pivot" (largest element) is immediately followed by the minimum element.
2. **Binary Search Logic:** - If `nums[mid] > nums[mid+1]`, then `mid+1` is the minimum.
   - If `nums[mid] < nums[mid-1]`, then `mid` is the minimum.
3. **Narrowing the Search:** - If `nums[mid] > nums[start]`, it means the left half is sorted normally, so the "drop-off" (minimum) must be in the right half.
   - Otherwise, the minimum is in the left half.
4. **Edge Case:** If no pivot is found (`pivot == -1`), it means the array was rotated `n` times (back to original sorted order). In this case, the first element `nums[0]` is the minimum.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝙡𝙤𝙜 𝙣) - We use Binary Search to find the inflection point.
* **Space Complexity:** 𝙊(𝟭) - No extra space used.

## 💻 Implementation (Java)
```java
class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        // The minimum element is at the start of the second sorted subarray
        int minIndex = findMinIndex(nums, start, end);
        
        // If findMinIndex returns -1, the array is not rotated (or rotated n times)
        if(minIndex != -1) return nums[minIndex];
        
        return nums[0];
    }

    int findMinIndex(int[] nums, int start, int end) {
        while(start < end) {
            int mid = start + (end - start) / 2;
            
            // Check if mid+1 is the minimum
            if(mid < end && nums[mid] > nums[mid+1]) {
                return mid + 1;
            }
            // Check if mid is the minimum
            if(mid > start && nums[mid] < nums[mid-1]) {
                return mid;
            }
            
            // Decide which side to search
            if(nums[mid] > nums[start]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return -1;
    }
}
