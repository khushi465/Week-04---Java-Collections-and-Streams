import java.util.*;
public class SetProg4 {
    List<Integer> setToSortedList(Set<Integer> set1){
        List<Integer> li=new ArrayList<>(set1);
        Collections.sort(li);
        return li;
    }
    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>(Arrays.asList(10,4,9,5,1,2));
        SetProg4 obj=new SetProg4();
        System.out.println("Set to sorted list: "+obj.setToSortedList(set1));
    }
}
