package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description 二叉树前序遍历
 * @author hongyanbo
 * @date 2020/6/17
 * @version 1.0.0
 * @since 1.0.0
 */
public class LeetCode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        traversal(root,list);
        return list;
    }

    private void traversal(TreeNode root,List<Integer> list) {
        if(root!=null){
            list.add(root.val);
            traversal(root.left,list);
            traversal(root.right,list);
        }
    }

    private class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
   }
}
