package graph.homework;

import java.util.*;

public class CloneGraph {

    static class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }

    private Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();

    /**
     * TC = O(V+E), SC = O(V) + O(H) = (O(H) = recursive stack space, H is the height of the graph)
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        visited.put(node, cloneNode);
        List<UndirectedGraphNode> neighbors = node.neighbors;
        for (UndirectedGraphNode neighbor : neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }

    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        visited.put(node, cloneNode);
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();
            List<UndirectedGraphNode> neighbors = n.neighbors;
            for (UndirectedGraphNode neighbor : neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.offer(neighbor);
                }
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Map<Node, Node> visited1 = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        // if the node is already visited then return the
        // clone of the node
        if (visited1.containsKey(node)) {
            return visited1.get(node);
        }
        Node cloneNode = new Node(node.val);
        visited1.put(node, cloneNode);
        List<Node> children = node.neighbors;
        for (Node v : children) {
            cloneNode.neighbors.add(cloneGraph(v));
        }
        return visited1.get(node);
    }

    public Node cloneGraph1(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> visited = new HashMap<>();
        Node clone = new Node(node.val);
        visited.put(node, clone);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            clone = visited.get(curr);
            List<Node> children = curr.neighbors;
            for (Node v : children) {
                // if there doesn't exists a clone of this node
                if (!visited.containsKey(v)) {
                    queue.offer(v);
                    Node neighborClone = new Node(v.val);
                    visited.put(v, neighborClone);
                }
                clone.neighbors.add(visited.get(v));
            }
        }
        return visited.get(node);
    }

    public static void main(String[] args) {

    }
}
