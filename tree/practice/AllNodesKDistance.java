package tree.practice;

import tree.TreeNode;

import java.util.*;

public class AllNodesKDistance {

    private Map<TreeNode, TreeNode> parentMap;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null || target == null) {
            return new ArrayList<>();
        }
        parentMap = new HashMap<>();
        // store every node's parent information in a hashmap so that you can
        // treat this tree as an undirected graph and can do BFS on a graph
        dfs(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        List<Integer> ans = new ArrayList<>();
        int currLevel = 0;
        while (!queue.isEmpty()) {
            if (currLevel == k) {
                for (TreeNode node : queue) {
                    ans.add(node.val);
                }
                return ans;
            } else {
                int size = queue.size();
                for (int i=0; i<size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null && !visited.contains(node.left)) {
                        queue.offer(node.left);
                        visited.add(node.left);
                    }
                    if (node.right != null && !visited.contains(node.right)) {
                        queue.offer(node.right);
                        visited.add(node.right);
                    }
                    TreeNode parent = parentMap.get(node);
                    if (parent != null && !visited.contains(parent)) {
                        queue.offer(parent);
                        visited.add(parent);
                    }
                }
                currLevel++;
            }
        }
        return ans;
    }

    private void dfs(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        parentMap.put(root, parent);
        dfs(root.left, root);
        dfs(root.right, root);
    }
}
