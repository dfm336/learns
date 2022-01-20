package com.dfm.his.jzoffer;

import java.util.Stack;

/**
 * @author dfm
 * @create 2020-11-29 13:50
 */
public class QueueByStack {

    Stack<Integer> stack1  = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(Integer val){
        stack1.push(val);
    }
    public int pop(){
        if(stack2.isEmpty() && stack1.isEmpty()){
            System.out.println("空");
        }


        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                Integer pop = stack1.pop();
                stack2.push(pop);
            }
        }
        return stack2.pop();

    }
}
class T{
    public static void main(String[] args) {
        QueueByStack queueByStack = new QueueByStack();
        queueByStack.push(1);
        queueByStack.push(2);
        queueByStack.push(3);
        queueByStack.push(4);
        queueByStack.push(5);

        for(int i=0;i<5;i++){
            System.out.println(queueByStack
            .pop());
        }
    }
}
