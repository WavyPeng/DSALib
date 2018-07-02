package wavy.applications.Stack.valid_parentheses;

import wavy.util.dsa.ArrayStack;

/**
 * 括号匹配
 * Created by WavyPeng on 2018/7/2.
 */
public class Solution {
    public boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if(stack.isEmpty())
                    return false;
                char top = stack.pop();
                if(c == ')' && top != '(')
                    return false;
                if(c == ']' && top != '[')
                    return false;
                if(c == '}' && top != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[}]";
        System.out.println(new Solution().isValid(s));
    }
}