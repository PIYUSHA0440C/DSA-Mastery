# 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points (Medium)


## 📝 Problem Statement


Given the head of a linked list, find the minimum and maximum distance between any two critical points.


A critical point is a node that is either a local maximum or a local minimum. The first and last nodes cannot be critical points because they do not have both a previous and a next node.


If there are fewer than two critical points, return `[-1, -1]`.


## 💡 Intuition & Approach


We traverse the linked list once while keeping track of the previous, current, and next nodes.


For every current node, we check whether it is a local maximum or local minimum by comparing its value with both neighboring nodes.


Instead of storing every critical point, we only need the **first critical point**, the **last critical point**, and the distance from the previous critical point. This is enough to calculate both required distances.


The minimum distance is the smallest gap between consecutive critical points, while the maximum distance is the distance between the first and last critical points.


### 🛠️ The Strategy:


1. Start traversing from the second node.
2. Compare the current node with its previous and next nodes.
3. Identify whether the current node is a local maximum or minimum.
4. Store the index of the first critical point.
5. For every subsequent critical point, update the minimum distance.
6. Update the last critical point's index.
7. If fewer than two critical points exist, return `[-1, -1]`.
8. Calculate the maximum distance using the first and last critical points.


## 📊 Complexity Analysis


* **Time Complexity:** O(n) - The linked list is traversed exactly once.


* **Space Complexity:** O(1) - Only a constant number of pointers and variables are used.


## 💻 Implementation (Java)


```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;

        int idx = 1;

        int firstCritical = -1;
        int lastCritical = -1;
        int minDist = Integer.MAX_VALUE;

        while(curr.next != null){
            ListNode next = curr.next;

            boolean isMax = curr.val > prev.val && curr.val > next.val;
            boolean isMin = curr.val < prev.val && curr.val < next.val;

            if(isMax || isMin){
                if (firstCritical == -1) firstCritical = idx;
                else minDist = Math.min(minDist, idx - lastCritical);

                lastCritical = idx;
            }

            prev = curr;
            curr = next;
            idx++;
        }

        if(firstCritical == -1 || firstCritical == lastCritical) return new int[]{-1, -1};

        int maxDist = lastCritical - firstCritical;

        return new int[]{minDist, maxDist};
    }
}
