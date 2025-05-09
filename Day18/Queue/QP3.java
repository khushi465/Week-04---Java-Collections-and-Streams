import java.util.*;
class Patient {
    String name;
    int severity;
    Patient(String name, int severity){
        this.name=name;
        this.severity=severity;
    }
    public String toString(){
        return name+" severity: "+severity;
    }

}
public class QP3{
    public static void main(String[] args) {
        Queue<Patient> queue=new PriorityQueue<>((p1,p2)->Integer.compare(p2.severity,p1.severity));
        // uses min heap by default so reversed order to get max heap
        queue.add(new Patient("John",3));

        while(!queue.isEmpty()){
            System.out.println(queue.remove());
        }
    }
}
