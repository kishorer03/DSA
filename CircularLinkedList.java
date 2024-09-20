public class CircularLinkedList {
    private LinkedList tail=null;
    private int length=0;

    private static class LinkedList{
        private int data;
        private LinkedList next;
        private LinkedList(int data){
            this.data=data;
            this.next=null;
        }
    }
    private boolean isEmpty(){
        return length==0;
    }
    private void insertAtStart(int data){
        LinkedList temp=new LinkedList(data);
        ++length;
        if(tail==null){
            tail=temp;
            tail.next=temp;
            return;
        }
        temp.next=tail.next;
        tail.next=temp;
    }
    private void insertAtEnd(int data){
        LinkedList temp=new LinkedList(data);
        ++length;
        if(tail==null){
            tail=temp;
            tail.next=temp;
            return;
        }
        temp.next=tail.next;
        tail.next=temp;
        tail=tail.next;
    }
    private void removeAtStart(){
        if(tail==null){
            return;
        }
        --length;
        LinkedList temp=tail.next;
        if(temp==tail){
            tail=null;
            return;
        }
        tail.next=temp.next;
        temp.next=null;
    }
    private void display(){
        LinkedList head=tail.next;
        while(head!=tail){
            System.out.print(head.data+" --> ");
            head=head.next;
        }
        System.out.print(head.data+" --> null");
    }
    public static void main(String[] args){
        CircularLinkedList m1=new CircularLinkedList();
        m1.insertAtStart(4);
        m1.insertAtStart(3);
        m1.insertAtStart(2);
        m1.insertAtStart(1);
        m1.insertAtEnd(5);
        m1.insertAtEnd(6);
        m1.insertAtEnd(7);
        m1.removeAtStart();
        m1.display();
    }
}
