package tree.practice;

import java.util.ArrayList;
import java.util.List;
import tree.TreeNode;

public class RightSideView {

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    List<TreeNode> currLevel = new ArrayList<>();
    if (root != null) {
      currLevel.add(root);
    }
    while (!currLevel.isEmpty()) {
      // add the last element of the currLevel to the result list
      int lastElement = currLevel.get(currLevel.size()-1).val;
      res.add(lastElement);
      List<TreeNode> nextLevel = new ArrayList<>();
      // add the children of each node in the current level
      // to the next level
      for (TreeNode node : currLevel) {
        if (node.left != null) {
          nextLevel.add(node.left);
        }
        if (node.right != null) {
          nextLevel.add(node.right);
        }
      }
      // set the nextLevel to the currLevel
      currLevel = nextLevel;
    }
    return res;
  }
}
