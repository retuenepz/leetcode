package leetcode.dfs;

import leetcode.bfs.LeetCode102;

/**
 * @description 二叉树的最大深度
 * @author hongyanbo
 * @date 2020/6/17
 * @version 1.0.0
 * @since 1.0.0
 */
public class LeetCode104 {
    int max = 0;
    public int maxDepth(TreeNode root) {
        traverse(root,1);
        return max;
    }

    private void traverse(TreeNode root,int dept) {
        if(root !=null){
            max = Math.max(max,dept);
            traverse(root.left,dept+1);
            traverse(root.right,dept+1);
        }
    }

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
