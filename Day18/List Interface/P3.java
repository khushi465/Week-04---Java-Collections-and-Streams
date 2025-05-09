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
    void addAtBeginning(int data){
        Node n=new Node(data);
        n.next=head;
        head=n;
    }
    int removeFromBeginning(){
        Node temp=head;
        int data;
        if(head==null){
            data=-1;
        }
       else{
        data=head.data;
        head=head.next;
       }
       return data;
    }
    void addAtEnd(int data){
        Node temp=head;
        if(head==null){
            addAtBeginning(data);
        }
        else{
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=new Node(data);
    }
    }
    void rotateList(int count){
        while(count>0){
            int data=removeFromBeginning();
            addAtEnd(data);
            count--;
        }
    }
    void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+", ");
            temp=temp.next;
        }
    }
}
public class P3{
    public static void main(String[] args) {
        NodeList nl=new NodeList();
        nl.addAtBeginning(50);
        nl.addAtBeginning(40);
        nl.addAtBeginning(30);
        nl.addAtBeginning(20);
        nl.addAtBeginning(10);
        nl.display();
        // nl.rotateList(2);
        nl.rotateList(2);
        nl.display();


    }
}