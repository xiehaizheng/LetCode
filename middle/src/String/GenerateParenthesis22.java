package String;

import java.util.ArrayList;
import java.util.List;

/*
* 22.括号生成
* 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
* 示例：
* 输入：n = 3
* 输出：[
*        "((()))",
*       "(()())",
*        "(())()",
*        "()(())",
*        "()()()"
*      ]
* 来源：力扣（LeetCode）
* */
public class GenerateParenthesis22 {
    public static void main(String[] args) {
        int n = 3;
        List<String> list = generateParenthesis(n);
        System.out.println(list);
    }
// 方法一：暴力法
//    public static List<String> generateParenthesis(int n){
//        List<String> combinations = new ArrayList<>();
//        generateAll(new char[n * 2],0,combinations);
//        return combinations;
//    }
//    public static void generateAll(char[] current,int pos,List<String > result){
//        if (pos == current.length){
//            if (valid(current)){
//                result.add(new String(current));
//            }
//        }else {
//            current[pos] = '(';
//            generateAll(current,pos + 1,result);
//            current[pos] = ')';
//            generateAll(current,pos + 1,result);
//
//        }
//    }
//    public static boolean valid(char[] current){
//        int blance = 0;
//        for (char c : current) {
//            if (c == '('){
//                blance ++;
//            }else{
//                blance--;
//            }
//            if (blance < 0){
//                return false;
//            }
//        }
//        return (blance == 0);
//    }
// 2.回溯法
    public static List<String> generateParenthesis(int n){
        List<String> list = new ArrayList<>();
        backtrack(list,new StringBuilder(),0,0,n);
        return list;
    }

    private static void backtrack(List<String> list, StringBuilder cur, int open, int close, int n) {
        if (cur.length() == n * 2){
            list.add(cur.toString());
            return;
        }
        if (open < n){
            cur.append('(');
            backtrack(list,cur,open+1,close,n);
            cur.deleteCharAt(cur.length() -1);
        }
        if (close < open){
            cur.append(')');
            backtrack(list,cur,open,close+1,n);
            cur.deleteCharAt(cur.length() -1);
        }
    }
}


