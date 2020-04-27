package leetcode;

import java.util.Stack;

/**
 * @description 有效的括号
 * @author hongyanbo
 * @date 2020/4/27
 * @version 1.0.0
 * @since 1.0.0
 */
public class LeetCode20 {
    /**
     * 入口
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        if(chars.length >0){
            for (char c : chars) {
                if(isLeft(c)){
                    stack.push(c);
                }else if(isRight(c)){
                    if(!stack.isEmpty()){
                        Character pop = stack.pop();
                        if(!match(pop,c)){
                            return false;
                        }
                    }else{
                        return false;
                    }

                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    private boolean match(char left, char right) {
        if(left == '(' && right==')'){
            return true;
        }
        if(left == '[' && right==']'){
            return true;
        }
        if(left == '{' && right=='}') {
            return true;
        }
        return false;
    }

    private boolean isRight(char c) {
        return c ==')' || c==']' || c=='}';
    }

    private boolean isLeft(char c) {
        return c =='(' || c=='[' || c=='{';
    }

    public static void main(String[] args) {
        new LeetCode20().isValid("]");
    }
}
