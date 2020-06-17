package leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description 二叉树的层序遍历
 * @author hongyanbo
 * @date 2020/6/17
 * @version 1.0.0
 * @since 1.0.0
 */
public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll!=null){
                    list.add(poll.val);
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
            }
            if(!list.isEmpty()){
                result.add(list);
            }
        }
        return result;
    }
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
