
import java.util.*;

public class SetProg1 {

    boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2){
        for (Integer elem : set1) {
            if(!set2.contains(elem))
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
    Set<Integer> set1=new HashSet<>(Arrays.asList(1,2,3));
    Set<Integer> set2=new HashSet<>(Arrays.asList(3,2,1));
    SetProg1 obj=new SetProg1();
    System.out.println(obj.areSetsEqual(set1, set2));
    
}
}