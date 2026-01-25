# 1832. Check if the Sentence Is Pangram (Easy)

## 📝 Problem Statement
A **pangram** is a sentence where every letter of the English alphabet appears at least once. 

Given a string `sentence` containing only lowercase English letters, return `true` if it is a pangram, or `false` otherwise.



## 💡 Intuition & Approach
To confirm a sentence is a pangram, we need to track if all 26 unique characters (a-z) are present.

1. **Data Structure:** I used a `HashSet<Character>`. A Set is perfect because it automatically ignores duplicate characters.
2. **Iteration:** Convert the string to a character array and iterate through it, adding each character to the Set.
3. **Validation:** In the English alphabet, there are 26 letters. If the size of the Set is **26**, it means we found every letter at least once.

## 📊 Complexity Analysis
* **Time Complexity:** 𝙊(𝙣) — Where n is the length of the string.
* **Space Complexity:** 𝙊(𝟭) — The Set will store a maximum of 26 characters, which is constant space.

## 💻 Code (Java)
```java
class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> alphabets = new HashSet<>();
        
        for(char ch : sentence.toCharArray()){
            alphabets.add(ch);
        }
        
        // Final check: do we have all 26 letters?
        return alphabets.size() == 26;
    }
}
