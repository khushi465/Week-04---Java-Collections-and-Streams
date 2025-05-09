import java.util.*;
public class SetProg2{
    Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> union=new HashSet<>(set1);
        // for (Integer elem : set2) {
        //     union.add(elem);
        // }
        union.addAll(set2);
        return union;
    }
    Set<Integer> getIntersection(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> intersection=new HashSet<>(set1);
        // for (Integer elem : set2) {
        //     if(set1.contains(elem)){
        //         intersection.add(elem);
        //     }
        // }
        intersection.retainAll(set2);
        return intersection;
    }

    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> set2=new HashSet<>(Arrays.asList(3,4,5));
        SetProg2 obj=new SetProg2();
        System.out.println("Union: "+obj.getUnion(set1,set2));
        System.out.println("Intersection: "+obj.getIntersection(set1, set2));
    }
}