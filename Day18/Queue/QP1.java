import java.util.*;
public class QP1{
    static void reverse(Queue<Integer> qu){
        if(qu.isEmpty()) return;
        int item=qu.remove();
        reverse(qu);
        qu.add(item);
    }
    public static void main(String[] args) {
        Queue<Integer> qu=new LinkedList<>();
        qu.add(10);
        qu.add(20);
        qu.add(30);
        reverse(qu);
        System.out.println(qu);
    }
}