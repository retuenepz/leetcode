package leetcode;

import java.util.Stack;

/**
 * @description 字符串解码
 * @author hongyanbo
 * @date 2020/6/4
 * @version 1.0.0
 * @since 1.0.0
 */
public class LeetCode394 {
    /**
     * main
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        String[] split = s.split("");
        for (String spl : split) {
            if(!spl.equals("]")){
                stack.push(spl);
            }else{
                String str = "";
                while (!stack.peek().equals("[")){
                    str =  stack.pop() + str;
                }
                stack.pop(); // [ 弹出
                String numStr = "";
                while(!stack.isEmpty() && stack.peek().charAt(0)>='0' && stack.peek().charAt(0)<='9'){
                    numStr = stack.pop() + numStr;
                }
                int i = Integer.parseInt(numStr);
                String result ="";
                while(i >0){
                    result += str;
                    i--;
                }
                stack.push(result);
            }
        }
        String res = "";
        while(!stack.isEmpty()){
            res = stack.pop() + res;
        }
        return res;
    }

    public static void main(String[] args) {
        new LeetCode394().decodeString("3[a]2[bc]");
    }
}
