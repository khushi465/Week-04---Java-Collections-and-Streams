import java.util.*;
public class QP2 {
    List<String> binary(int n){
        List<String> result=new ArrayList<>();
        // stores all the binary numbers as alist
        Queue<String> queue=new LinkedList<>();
        // is the binary number made
        queue.add("1");
        for (int i = 0; i < n; i++) {
            String curr=queue.remove();
            result.add(curr);
            queue.add(curr+"0");
            queue.add(curr+"1");
        }
    return result;
    }
    public static void main(String[] args) {
  QP2 obj=new QP2();    
  List<String> qu=obj.binary(5);
        System.out.println(qu);
    }
}
