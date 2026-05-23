# 1089. Duplicate Zeros (Easy)

## 📝 Problem Statement
Given a fixed-length integer array `arr`, duplicate each occurrence of zero, shifting the remaining elements to the right. Elements beyond the length of the original array are not written. Modify the input array in-place and do not return anything.

## 💡 Intuition & Approach
The challenge of duplicating elements in-place within a fixed-length array is avoiding the loss of subsequent numbers when shifting. A straightforward, bug-free way to manage this without tracking manual shifts is using an auxiliary array to simulate the written stream.

### 🛠️ The Strategy:
1. **Auxiliary Blueprint:** Initialize an auxiliary array `ans` of the exact same length as `arr`.
2. **Dual Pointer Write:** Track our position in the original array with pointer `i` and our placement position in the new array with pointer `j`.
3. **Simulated Expansion:** 
   - Write the current element `arr[i]` into `ans[j++]`.
   - If `arr[i]` is a `0`, check if there is remaining space left in the array (`j < len`). If space permits, write a duplicate `0` into `ans[j++]`.
4. **Array Restoration:** Copy all synchronized values from `ans` back into `arr` to complete the required in-place modification.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - We make exactly one pass to build the matching sequence up to length $n$, and a second linear pass to copy the values back into the source array.
* **Space Complexity:** 𝙊(𝗻) - An auxiliary array of size $n$ is allocated to safely construct the shifted variations.

## 💻 Implementation (Java)
```java
class Solution {
    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        int[] ans = new int[len];
        int j = 0;

        // Populate auxiliary array up to bounds
        for (int i = 0; i < len && j < len; i++) {
            ans[j++] = arr[i];

            // If a zero is encountered and space remains, duplicate it
            if (arr[i] == 0 && j < len) {
                ans[j++] = 0;
            }
        }

        // Copy elements back to meet in-place modification requirements
        for (int i = 0; i < len; i++) {
            arr[i] = ans[i];
        }
    }
}
