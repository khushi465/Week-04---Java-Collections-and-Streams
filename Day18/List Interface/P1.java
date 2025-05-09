import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class NodeList{
    private Node head;
    int count=0;
    void addAtBeginning(int data){
        Node n=new Node(data);
        n.next=head;
        head=n;
        count++;
        // System.out.print(data);
        // System.out.println(count);
    }
    void addAtEnd(int data){
        Node n=new Node(data);
        if(head==null){
            head=n;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=n;
        count++;
    }
    int removeFromBeginning(){
        count--;
        int data=head.data;
        // System.out.println(data);
        head=head.next;
        return data;
    }
    NodeList reverse(){
        Node temp=head;
        // System.out.println(count);
        NodeList n=new NodeList();
        temp=head;
        int t=count-1;
        while(temp!=null&&t>=0){
            t--;
            int data=removeFromBeginning();
            n.addAtBeginning(data);
            // System.out.println(data);
            addAtEnd(data);
            temp=temp.next;
        }
        return n;
    }
    void display(){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
}
class ArrayListReverse{
    public static ArrayList<Integer> reverse(ArrayList<Integer> arr){
        ArrayList<Integer> arr1=new ArrayList<>();
        for (int i = arr.size()-1; i >=0 ; i--) {
            arr1.add(arr.get(i));
        }
        // System.out.println(arr1);

        return arr1;
    }
}

public class P1{
    public static void main(String[] args) {
        NodeList nl=new NodeList();
        nl.addAtBeginning(1);
        nl.addAtBeginning(2);
        nl.addAtBeginning(3);
        nl.addAtBeginning(4);
        nl.addAtBeginning(5);
        nl.display();
        NodeList n=nl.reverse();
        n.display();
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        arr.add(9);
        ArrayList<Integer> arr1=ArrayListReverse.reverse(arr);
        System.out.println(arr1);
        
    }
}