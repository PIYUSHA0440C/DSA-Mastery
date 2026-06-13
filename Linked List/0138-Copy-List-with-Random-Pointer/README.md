# 138. Copy List with Random Pointer (Medium)

## 📝 Problem Statement
A linked list of length `n` is given such that each node contains an additional random pointer, which could point to any node in the list, or `null`. Construct a deep copy of the list. The deep copy should consist of exactly `n` brand new nodes, where each new node has its value set to the value of its corresponding original node. None of the pointers in the new list should point to nodes in the original list.

## 💡 Intuition & Approach
Deep copying a standard linked list only requires iterating forward and linking the `next` pointers. However, a `random` pointer can point to any node anywhere in the list, including nodes that haven't been created yet.

To handle this, we use a two-pass strategy with a **HashMap**:
1. **Pass 1 (Cloning Nodes):** Traverse the original list. Create a brand-new node clone for each node we encounter, link them sequentially via their `next` pointers, and log the mapping `originalNode -> clonedNode` inside our `HashMap`.
2. **Pass 2 (Wiring Random Pointers):** Reset our pointers to the start. Traverse both lists simultaneously. For every node, extract its original random target, locate the corresponding clone inside our map (`map.get(temp.random)`), and link the clone's random pointer to it.

## 📊 Complexity Analysis
* **Time Complexity:** O(N) - We perform two independent linear passes over the linked list. Dictionary insertions and lookups operate in average $O(1)$ constant time.
* **Space Complexity:** O(N) - The `HashMap` stores exactly $N$ key-value pairs mapping every original node to its respective clone.

## 💻 Implementation (Java)
```java
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(-1);
        Node node = dummy;
        HashMap<Node, Node> map = new HashMap<>();

        // Step 1: Create cloned nodes and wire their next pointers
        Node temp = head;
        while (temp != null) {
            Node nextNode = new Node(temp.val);
            node.next = nextNode;
            
            // Map the original node to its new clone
            map.put(temp, nextNode);
            
            temp = temp.next;
            node = node.next;
        }

        // Step 2: Wire the random pointers using our map lookups
        temp = head;
        node = dummy.next;
        while (temp != null) {
            // Point the clone's random reference to the clone of the original random node
            node.random = map.get(temp.random);

            node = node.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}
