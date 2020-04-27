package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 完全平方数 BFS
 * 找到从N到0的最短路径
 * @description
 * @author hongyanbo
 * @date 2020/4/27
 * @version 1.0.0
 * @since 1.0.0
 */
public class LeetCode279 {
    /**
     * 入口
     * @param n
     * @return
     */
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList();
        Set<Integer> visited = new HashSet<>();
        queue.offer(n);
        visited.add(n);
        int step = 0;
        while(queue.size()>0){
            int size = queue.size();
            for(int j =0; j < size ; j++){
                int poll = queue.poll();
                if(poll == 0){
                    return step;
                }else{
                    for (int i = 1; i*i <= poll ; i++) {
                        int next = poll - i * i;
                        if(!visited.contains(next)){
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
            step ++;
        }
        return step;
    }

    public static void main(String[] args) {
        int i = new LeetCode279().numSquares(12);
        System.out.println(i);
    }
}
