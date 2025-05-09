
import java.util.*;

class StackUsingQueue {

    private Queue<Integer> q1 = new LinkedList<>();
    // stores the stack form of queue
    private Queue<Integer> q2 = new LinkedList<>();

    public void push(int i) {
        q2.add(i);
        // adds to q2 and adds all other elements after it 
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
            // removes from front
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty"); 
        }else {
            return q1.remove();
        }
    }

    public int top() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty"); 
        }else {
            return q1.peek();
        }
    }
}

public class QP4 {

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}
