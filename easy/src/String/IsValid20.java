package String;

import java.util.HashMap;
import java.util.Stack;

/*
* 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
* 有效字符串需满足：1.左括号必须用相同类型的右括号闭合.2.左括号必须以正确的顺序闭合.
* 注意空字符串可被认为是有效字符串。
* */
public class IsValid20 {
    public static void main(String[] args) {
        String  str = "(){}[]";
        Boolean res = isValid(str);
        System.out.println(res);
    }
    public static boolean isValid(String str){
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < str.length() ; i++){
            char c = str.charAt(i);
            if (map.containsKey(c)){
                Character topElement =  stack.isEmpty()? '#': stack.pop();
                if (topElement != map.get(c)){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
