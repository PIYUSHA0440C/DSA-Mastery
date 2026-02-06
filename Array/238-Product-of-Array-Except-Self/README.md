# 238. Product of Array Except Self (Medium)

## 📝 Problem Statement
Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`. 

**Constraints:**
- Must run in **O(n)** time.
- Must **not** use the division operation.
- Follow-up: Solve in **O(1)** extra space (excluding the output array).

## 💡 Intuition & Approach
The product of all elements except `nums[i]` is simply:
`(Product of all elements to the left of i) * (Product of all elements to the right of i)`

### 🛠️ The Strategy:
1. **Left (Prefix) Pass:** Create the `answer` array where each index `i` stores the product of all elements before it. We use a variable `prefix` to keep a running product.
2. **Right (Postfix) Pass:** Traverse the array backward. Use a variable `postfix` to keep track of the product of all elements to the right of `i`. Multiply the existing value in `answer[i]` (the prefix) by the current `postfix`.
3. **Efficiency:** By updating the `answer` array in place during the second pass, we avoid using extra space for a separate suffix array.



## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - Two linear passes through the array.
* **Space Complexity:** 𝙊(𝟭) - No extra space used besides the output array (as per problem follow-up).

## 💻 Implementation (Java)
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        
        // Pass 1: Prefix products
        int prefix = 1;
        for(int i = 0; i < len; i++){
            answer[i] = prefix;
            prefix *= nums[i];
        }
        
        // Pass 2: Postfix products
        int postfix = 1;
        for(int i = len - 1; i >= 0; i--){
            answer[i] = postfix * answer[i];
            postfix *= nums[i];
        }
        
        return answer;
    }
}
