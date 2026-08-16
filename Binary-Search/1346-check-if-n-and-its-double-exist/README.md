# 1346. Check If N and Its Double Exist (Easy)


## 📝 Problem Statement


Given an array `arr` of integers, check if there exist two different indices `i` and `j` such that:


- `i != j`
- `arr[i] == 2 * arr[j]`


Return `true` if such a pair exists, otherwise return `false`.


## 💡 Intuition & Approach


We use a **HashSet** to store the numbers that have already been encountered.


For every number, we check two possibilities:


1. Whether `num * 2` has already appeared in the set.
2. If `num` is even, whether `num / 2` has already appeared in the set.


If either condition is true, a valid pair has been found.


Checking both possibilities ensures that the pair is detected regardless of which element appears first in the array.


### 🛠️ The Strategy:


1. Create a `HashSet` to store previously visited numbers.
2. Traverse the array from left to right.
3. For each `num`, check if `num * 2` exists in the set.
4. If `num` is even, check if `num / 2` exists in the set.
5. If either condition is satisfied, return `true`.
6. Add `num` to the set.
7. If no valid pair is found, return `false`.


## 📊 Complexity Analysis


* **Time Complexity:** O(n) - Each element is processed once with O(1) average-time HashSet operations.


* **Space Complexity:** O(n) - In the worst case, the HashSet stores all elements.


## 💻 Implementation (Java)


```java
class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : arr){
            if(set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))){
                return true;
            }

            set.add(num);
        }

        return false;
    }
}
