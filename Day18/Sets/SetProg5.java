import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetProg5 {

    public boolean isSubset(Set<Integer> set1, Set<Integer> set2){
        for (Integer elem : set2) {
            if(!set1.contains(elem)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
    Set<Integer> set1=new HashSet<>(Arrays.asList(1,2,3,4));
    Set<Integer> set2=new HashSet<>(Arrays.asList(2,3));
        SetProg5 obj=new SetProg5();
        // if set2 is subset of set1
        System.out.println("Is Subset: "+obj.isSubset(set2,set1));
    
}}


// reverse ke tarike
// left<right tak left and right ko exchange and left++ right--
// remove then reverse call then add
