package leetcode;

import java.util.Stack;

/**
 * @description 每日温度
 * 栈结构的使用
 * @author hongyanbo
 * @date 2020/5/9
 * @version 1.0.0
 * @since 1.0.0
 */
public class LeetCode739 {
    public int[] dailyTemperatures(int[] T) {
        int [] result = new int[T.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < T.length; i++) {
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
