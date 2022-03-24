package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最小栈
 *
 * @author Mr.黄
 * @date 2022/03/25
 **/
public class Leetcode155 {
    class MinStack {
        Deque<Integer> xStack;
        Deque<Integer> minStack;
        
        public MinStack() {
            xStack = new LinkedList<Integer>();
            minStack = new LinkedList<Integer>();
            minStack.push(Integer.MAX_VALUE);
        }
        
        public void push(int x) {
            xStack.push(x);
            minStack.push(Math.min(minStack.peek(), x));
        }
        
        public void pop() {
            xStack.pop();
            minStack.pop();
        }
        
        public int top() {
            return xStack.peek();
        }
        
        public int getMin() {
            return minStack.peek();
        }
    }
}