/**
* 最小栈
* 
*/
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 实现 MinStack 类: 
//
// 
// MinStack() 初始化堆栈对象。 
// void push(int val) 将元素val推入堆栈。 
// void pop() 删除堆栈顶部的元素。 
// int top() 获取堆栈顶部的元素。 
// int getMin() 获取堆栈中的最小元素。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// -231 <= val <= 231 - 1 
// pop、top 和 getMin 操作总是在 非空栈 上调用 
// push, pop, top, and getMin最多被调用 3 * 104 次 
// 
// Related Topics 栈 设计 
// 👍 1215 👎 0
	
package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.Stack;

/**
* 155
*/
public class MinStack {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
    
    public MinStack() {
        this.dataStack = new Stack<>();
        this.minValueStack = new Stack<>();
    }
    
    private Stack<Integer> dataStack;
    
    private Stack<Integer> minValueStack;
    public void push(int val) {
        if (this.minValueStack.isEmpty()){
            minValueStack.push(val);
        }else {
            int minValue = getMin();
            if (val<minValue){
                minValue = val;
            }
            minValueStack.push(minValue);
        }
        dataStack.push(val);
        
    }
    
    public void pop() {
        if (dataStack.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        dataStack.pop();
        minValueStack.pop();
        
    }
    
    public int top() {
        if (dataStack.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        return dataStack.peek();
    }
    
    public int getMin() {
        if (minValueStack.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        return minValueStack.peek();
    }
    class MinStack2 {
        class ListNode {
            public int val;
            public int min;//最小值
            public ListNode next;

            public ListNode(int val, int min, ListNode next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }
        private ListNode head;

        public void push(int val) {
            if (isEmpty()) {
                head=new ListNode(val,val,null);
            }else {
                ListNode temp=head;
                head=new ListNode(val,Math.min(temp.min,val),temp);
            }
        }

        public void pop() {
            head=head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
        public boolean isEmpty(){
            return head==null;
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
    
    
    
    
    
    
        
  
    
    
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}