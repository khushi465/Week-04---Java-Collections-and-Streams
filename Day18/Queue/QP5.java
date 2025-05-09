class CircularBuffer{
    int capacity;
    int[] buffer;
    int index=0;

    public CircularBuffer(int capacity) {
        this.capacity=capacity;
        this.buffer=new int[capacity];
    }
    void add(int i){
        if(index<capacity){
            buffer[index]=i;
            index++;
        }
        else{
            for (int j = 0; j < buffer.length-1; j++) {
                buffer[j]=buffer[j+1];
            }
            buffer[buffer.length-1]=i;
        }
    }
    void display(){
        for (int i = 0; i < buffer.length; i++) {
            System.out.print(buffer[i]+" ");
        }
    }
    
}

public class QP5 {
    public static void main(String[] args) {
        CircularBuffer cb=new CircularBuffer(3);
        cb.add(1);
        cb.add(2);
        cb.add(3);
        cb.display();
        cb.add(4);
        cb.display();
    }
}
