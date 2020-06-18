package leetcode.bfs;

import leetcode.dfs.LeetCode104;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description 对称二叉树
 * @author hongyanbo
 * @date 2020/6/17
 * @version 1.0.0
 * @since 1.0.0
 */
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMiror(root.left,root.right);
    }

    private boolean isMiror(TreeNode left, TreeNode right) {
        if(left ==null && right==null){
            return true;
        }
        if(left ==null || right == null){
           return false;
        }
        return left.val == right.val && isMiror(left.left,right.right) && isMiror(left.right,right.left);
    }

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
