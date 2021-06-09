package linkedlist.practice;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class DoubleLinkedList {
        int key;
        int val;
        DoubleLinkedList prev;
        DoubleLinkedList next;
    }

    private void removeNode(DoubleLinkedList node) {
        DoubleLinkedList prev = node.prev;
        DoubleLinkedList next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void addNode(DoubleLinkedList node) {
        node.prev = head;
        node.next = head.next;

        head.next = node;
        node.next.prev = node;
    }

    private void moveToHead(DoubleLinkedList node) {
        removeNode(node);
        addNode(node);
    }

    private DoubleLinkedList removeTail() {
        DoubleLinkedList tail = this.tail.prev;
        removeNode(tail);
        return tail;
    }


    private Map<Integer, DoubleLinkedList> map;
    // pseudo head and tail
    private DoubleLinkedList head, tail;
    private int count, capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.map = new HashMap<>();

        this.head = new DoubleLinkedList();
        this.tail = new DoubleLinkedList();

        this.head.prev = null;
        this.tail.next = null;

        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        DoubleLinkedList node = map.get(key);
        // the key doesn't exist
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DoubleLinkedList node = map.get(key);
        if (node == null) {
            DoubleLinkedList newNode = new DoubleLinkedList();
            newNode.key = key;
            newNode.val = value;
            // add the node in the linked list
            addNode(node);
            map.put(key, node);

            count++;
            // if the count exceeds the LRU cache's capacity then
            // remove the LRU node
            if (count > capacity) {
                DoubleLinkedList tail = removeTail();
                map.remove(tail.key);
                count--;
            }
        } else {
            // the node is already present, update the value of the node
            node.val = value;
            moveToHead(node);
        }
    }
}
