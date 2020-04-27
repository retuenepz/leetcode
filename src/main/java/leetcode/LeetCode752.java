package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 打开转盘所 BFS 解法
 * @description TODO
 * @author hongyanbo
 * @date 2020/4/22
 * @version 1.0.0
 * @since 1.0.0
 */
public class LeetCode752 {
    /**
     * 入口
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {

        LinkedList<String> list = new LinkedList<>();
        HashSet<String> visted = new HashSet<>();
        HashSet<String> dead = new HashSet<>();
        dead.addAll(Arrays.asList(deadends));

        list.add("0000");
        visted.add("0000");
        int step = 0;
        while(list.size()>0){
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String poll = list.poll();
                if(dead.contains(poll)){
                    continue;
                }else if(poll.equals(target)){
                    return step;
                }else{
                    for (int j = 0; j < 4; j++) {
                        String res1 = roll(poll, j, 1);
                        String res2 = roll(poll, j, -1);
                        if(!visted.contains(res1)){
                            list.offer(res1);
                            visted.add(res1);
                        }
                        if(!visted.contains(res2)){
                            list.offer(res2);
                            visted.add(res2);
                        }
                    }
                }
            }

            step++;
        }
        return -1;
    }

    /**
     * 转动一次锁
     * @param origin 原始状态
     * @param i 转动第i个密码位
     * @param direction 转动的方向
     */
    private String roll(String origin, int i, int direction) {
        char c = origin.charAt(i);
        int a = ((c - '0') + direction + 10) % 10;
        return origin.substring(0, i) + ("" + a) + origin.substring(i + 1);
    }

    public static void main(String[] args) {
        LeetCode752 leetCode752 = new LeetCode752();
        int i = leetCode752.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
        System.out.println(i);
    }


}