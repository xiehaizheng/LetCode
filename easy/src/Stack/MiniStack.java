package Stack;

import java.util.Stack;

/*
* 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈
* push(x) — 将元素 x 推入栈中。pop()— 删除栈顶的元素。top()— 获取栈顶元素。getMin()— 检索栈中的最小元素。
* 提示：pop、top 和 getMin 操作总是在 非空栈 上调用。
* 输入：["MinStack","push","push","push","getMin","pop","top","getMin"] [[],[-2],[0],[-3],[],[],[],[]]
* 输出：[null,null,null,null,-3,null,0,-2]
* 解释：
* MinStack minStack = new MinStack();
* minStack.push(-2);
* minStack.push(0);
* minStack.push(-3);
* minStack.getMin();   --> 返回 -3.
* minStack.pop();
* minStack.top();      --> 返回 0.
* minStack.getMin();   --> 返回 -2.
* 来源：力扣（LeetCode）
* */
public class MiniStack {
    public static void main(String[] args) {
        MiniStack obj = new MiniStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        int min = obj.getMin();
        System.out.println("第一次最小值为：" + min);
        obj.pop();
        int top = obj.top();
        System.out.println("栈顶元素为：" + top);
        int min2 =  obj.getMin();
        System.out.println("第二次的你最小值为：" + min2);
    }
     private Stack<Integer> dataStack;
     private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MiniStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }
    //push(x) — 将元素 x 推入栈中
    public  void push(int x){
        dataStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }
    // pop()— 删除栈顶的元素。
    public  void pop(){
        int top = dataStack.pop();
        if(top ==  minStack.peek()){
            minStack.pop();
        }
    }
    // top()— 获取栈顶元素。
    public int top(){
        return dataStack.peek();
    }
    //  getMin()— 检索栈中的最小元素。
    public int  getMin(){
        return minStack.peek();
    }
}
