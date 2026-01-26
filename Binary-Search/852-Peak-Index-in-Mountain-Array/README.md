# 852. Peak Index in a Mountain Array (Medium)

## 📝 Problem Statement
An array `arr` is a **mountain** if it increases to a peak element and then decreases. Given such an array, return the index of the peak element.

You must solve it in **O(log n)** time complexity.



## 💡 Intuition & Approach
Even though the array isn't fully sorted, it has a "structural order" (increasing then decreasing). This allows us to use **Binary Search**.

1. **The Logic:** We compare `arr[mid]` with `arr[mid + 1]`.
   - If `arr[mid] > arr[mid + 1]`: We are in the **decreasing** part of the mountain. The peak could be `mid` or to the left. So, `end = mid`.
   - If `arr[mid] < arr[mid + 1]`: We are in the **increasing** part of the mountain. The peak must be to the right of `mid`. So, `start = mid + 1`.
2. **Convergence:** The loop runs while `start < end`. When they meet, both pointers will point to the largest element, which is the peak.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝙡𝙤𝙜 𝙣) - We reduce the search space by half in each iteration.
* **Space Complexity:** 𝙊(𝟭) - No extra space used.

## 💻 Implementation (Java)
```java
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int mid = start + (end - start) / 2;
            
            if (arr[mid] > arr[mid + 1]){
                // We are in the decreasing part
                // This mid could be the answer, but check left
                end = mid; 
            }
            else { // arr[mid] < arr[mid + 1]
                // We are in the increasing part
                // mid + 1 is better than mid, so search right
                start = mid + 1;
            }
        }
        // start and end will converge to the peak index
        return start; 
    }
}
