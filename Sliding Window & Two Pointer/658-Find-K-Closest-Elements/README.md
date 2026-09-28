# 658. Find K Closest Elements (Medium)

## 📝 Problem Statement

Given a sorted integer array `arr`, two integers `k` and `x`, return the `k` closest integers to `x` in the array. The result should also be sorted in ascending order.

If two integers have the same distance from `x`, the smaller integer is considered closer.

## 💡 Intuition & Approach

Because the array is sorted and the answer consists of `k` consecutive elements, we can use **binary search** to find the starting position of the best window.

For a window starting at `mid`, compare the elements just outside the possible window: `arr[mid]` and `arr[mid + k]`. If the right element is closer to `x`, the window should move right; otherwise, it can remain at or move left of `mid`.

### 🛠️ The Strategy:

1. Set the binary search range from `0` to `arr.length - k`.
2. Calculate the middle starting index `mid`.
3. Compare the distances of `arr[mid]` and `arr[mid + k]` from `x`.
4. If `arr[mid + k]` is closer, move `left` to `mid + 1`.
5. Otherwise, move `right` to `mid`.
6. When the search ends, `left` is the starting index of the required window.
7. Add the `k` elements from that position to the result.

## 📊 Complexity Analysis

- **Time Complexity:** `O(log(n - k) + k)`
- **Space Complexity:** `O(k)` for the result list.

## 💻 Implementation (Java)

```java
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;

        while(left < right){
            int mid = left + (right - left) / 2;

            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> result = new ArrayList<>(k);

        for(int i = left; i < left + k; i++){
            result.add(arr[i]);
        }

        return result;
    }
}
```
