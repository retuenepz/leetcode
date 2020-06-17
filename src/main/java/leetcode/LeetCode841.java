package leetcode;

import java.util.List;
import java.util.Stack;

/**
 * @description 钥匙和房间
 * @author hongyanbo
 * @date 2020/6/5
 * @version 1.0.0
 * @since 1.0.0
 */
public class LeetCode841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visted = new boolean[rooms.size()];
        Stack<Integer> stack = new Stack();
        stack.push(0);
        while(!stack.isEmpty()){
            Integer pop = stack.pop();
            visted[pop]=true;
            List<Integer> keys = rooms.get(pop);
            for (Integer key : keys) {
                if(!visted[key]==true){
                    stack.push(key);
                }
            }
        }
        for (boolean b : visted) {
            if(b==false){
                return false;
            }
        }
        return true;
    }
}
