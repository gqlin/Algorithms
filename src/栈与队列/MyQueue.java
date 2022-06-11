package 栈与队列;

import java.util.Stack;

/**
 * @description：
 * @date： 2022/4/27 14:38
 * @author：gqlin
 */
/*
        232. 用栈实现队列
        请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：

        实现 MyQueue 类：

        void push(int x) 将元素 x 推到队列的末尾
        int pop() 从队列的开头移除并返回元素
        int peek() 返回队列开头的元素
        boolean empty() 如果队列为空，返回 true ；否则，返回 false
        说明：

        你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
        你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。


        示例 1：

        输入：
        ["MyQueue", "push", "push", "peek", "pop", "empty"]
        [[], [1], [2], [], [], []]
        输出：
        [null, null, null, 1, 1, false]

        解释：
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false*/

public class MyQueue {
    Stack<Integer> stackIn;//负责进队列
    Stack<Integer> stackOut;//负责出队列

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        dumpInToOut();
        return stackOut.pop();
    }

    public int peek() {
        dumpInToOut();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackOut.empty() && stackIn.empty();
    }

    //因为队列先进先出的性质，pop、peek操作，都要在stackOut中进行
    //如果stackOut为空，则要把stackIn中的元素全部pop，stackOut将stackIn中pop出元素压栈，再pop、peek，才能保证先进先出的原则
    //如果stackOut不为空，stackOut直接pop、peek，就是
    public void dumpInToOut() {
        if (!stackOut.empty()) {
            return;
        }
        while (!stackIn.empty()) {
            stackOut.push(stackIn.pop());
        }
    }

}
