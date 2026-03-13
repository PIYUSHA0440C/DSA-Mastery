# 151. Reverse Words in a String (Medium)

## 📝 Problem Statement
Given an input string `s`, reverse the order of the words. A word is defined as a sequence of non-space characters. The words in `s` will be separated by at least one space. The output should have words in reverse order, separated by a single space, with no leading or trailing spaces.

## 💡 Intuition & Approach
The most straightforward way to reverse the words while ignoring irregular spacing is to split the string into an array and process it from the end.

### 🛠️ The Strategy:
1. **Split:** Use `s.split(" ")` to break the string into an array of words. Note that multiple spaces will result in empty strings in the array.
2. **Backward Iteration:** Iterate through the array starting from the last index (`words.length - 1`) down to 0.
3. **Empty String Check:** Within the loop, skip any elements that are empty strings using `if(words[i].equals(""))`.
4. **Build Result:** Append each valid word followed by a space to a `StringBuilder`.
5. **Final Cleanup:** Remove the trailing space added after the last word using `deleteCharAt()` and return the string.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝗻) - One pass for splitting and one pass for building the result string.
* **Space Complexity:** 𝙊(𝗻) - To store the split words and the final string builder.

## 💻 Implementation (Java)
```java
class Solution {
    public String reverseWords(String s) {
        // Split by spaces - consecutive spaces result in empty strings in the array
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = words.length - 1; i >= 0; i--) {
            // Skip empty strings caused by extra spaces
            if(words[i].equals("")) continue;
            
            sb.append(words[i]);
            sb.append(" ");
        }
        
        // Remove the extra space at the end
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return sb.toString();
    }
}
