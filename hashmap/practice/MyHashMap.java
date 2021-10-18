package hashmap.practice;

public class MyHashMap {

    static class ListNode {
        int key;
        int val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    private ListNode[] buckets;

    public MyHashMap() {
        this.buckets = new ListNode[10000];
    }

    public void put(int key, int value) {
        // find the bucket location
        int i = hash(key);
        if (buckets[i] == null) {
            buckets[i] = new ListNode(-1, -1);
        }
        // find the last node in the bucket location which is
        // not equal to the given key
        ListNode prev = find(buckets[i], key);
        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.val = value;
        }
    }

    public int get(int key) {
        // find the hash of the given key
        int i = hash(key);
        if (buckets[i] == null) {
            return -1;
        }
        ListNode prev = find(buckets[i], key);
        if (prev.next == null) {
            return -1;
        }
        return prev.next.val;
    }

    public void remove(int key) {
        int i = hash(key);
        if (buckets[i] == null) {
            return;
        }
        ListNode prev = find(buckets[i], key);
        if (prev.next == null) {
            return;
        }
        prev.next = prev.next.next;
    }

    private int hash(int key) {
        return Integer.hashCode(key) % buckets.length;
    }

    private ListNode find(ListNode node, int key) {
        ListNode temp = node, prev = null;
        while (temp != null && temp.key != key) {
            prev = temp;
            temp = temp.next;
        }
        return prev;
    }
}
