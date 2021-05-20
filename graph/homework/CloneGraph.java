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
}
