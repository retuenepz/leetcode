package leetcode;

import java.util.Stack;


/**
 * @description 逆波兰表达式求值
 * @author hongyanbo
 * @date 2020/5/11
 * @version 1.0.0
 * @since 1.0.0
 */
public class LeetCode150 {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if(isNotNum(token)){
                int pop = Integer.parseInt(stack.pop());
                int pop1 = Integer.parseInt(stack.pop());
                if("+".equals(token)){
                    stack.push(String.valueOf(pop1 + pop));
                }else if("-".equals(token)){
                    stack.push(String.valueOf(pop1 - pop));
                }else if("*".equals(token)){
                    stack.push(String.valueOf(pop1 * pop));
                }else if("/".equals(token)){
                    stack.push(String.valueOf(pop1 / pop));
                }
            }else{
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     *
     * @param token
     * @return
     */
    private boolean isNotNum(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }
}
