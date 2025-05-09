import java.util.*;

public class SetProg3 {
    Set<Integer> getDiff(Set<Integer> set1, Set<Integer> set2){
        // Set<Integer> res=new HashSet<>(set1);
        // Set<Integer> opp=new HashSet<>(set1);
        // res.addAll(set2);
        // opp.retainAll(set2);
        // for (Integer elem : res) {
            //     if(!opp.contains(elem)){
                //         symDiff.add(elem);
                //     }
                // }
        Set<Integer> symDiff=new HashSet<>(set1);
        for (Integer elem : set2) {
            // res.add returns false if element is already present in the set
            if(!symDiff.add(elem)){
                symDiff.remove(elem);
            }
        }
        return symDiff;
    }
    public static void main(String[] args) {    
    Set<Integer> set1=new HashSet<>(Arrays.asList(1,2,3));
    Set<Integer> set2=new HashSet<>(Arrays.asList(3,4,5));
    SetProg3 obj=new SetProg3();
    System.out.println("Sym diff: "+obj.getDiff(set1,set2));
}
}