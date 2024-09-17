import java.util.Scanner;

public class SingleLinkedList{
    private SingleLinked head;

    static class SingleLinked{
        private int data;
        private SingleLinked next;
        private SingleLinked(int data){
            this.data=data;
            this.next=null;
        }
    }

    public void display(){
        if(head == null){
            System.out.println("null");
            return;
        }
        SingleLinked custom=head;
        while(custom!=null){
            System.out.print(custom.data+"  ");
            custom=custom.next;
        }
        System.out.println();
    }

    public int count(){
        SingleLinked custom=head;
        int count=0;
        while(custom!=null){
            count++;
            custom=custom.next;
        }
        return count;
    }

    public void insertAtStart(int a){
        SingleLinked element=new SingleLinked(a);
        element.next=head;
        head=element;
    }

    public SingleLinked insertAtEnd(int a){
        SingleLinked element=new SingleLinked(a);
        if(head == null){
            head=element;
            return null;
        }
        SingleLinked temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=element;
        temp=temp.next;
        return temp;
    }

    public void insertAtPos(int pos,int a){
        int count=0;
        SingleLinked temp=head;
        SingleLinked newNode=new SingleLinked(a);
        if(pos==1){
            insertAtStart(a);
            return;
        }
        while(count<pos-2){
            temp=temp.next;
            ++count;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public void deleteAtStart(){
        if(head==null){
            return;
        }
        head=head.next;
    }

    public void deleteAtPos(int pos){
        if(pos==0){
            deleteAtStart();
            return;
        }
        if(count()-1<pos || pos<0){
            return;
        }
        SingleLinked dum=head;
        int count=0;
        while(count<pos-1){
            dum=dum.next;
            count++;
        }
        dum.next=(dum.next).next;
    }

    public void deleteAtFirst(){
        if(head==null){
            return;
        }
        head=head.next;
    }
    public void deleteAtLast(){
        if(head==null){
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        SingleLinked dum=head;
        while(dum.next.next!=null){
            dum=dum.next;
        }
        dum.next=null;
    }

    public boolean searchElement(int value){
        if(head==null){
            return false;
        }
        SingleLinked dum=head;
        while(dum!=null){
            if(dum.data==value){
                return true;
            }
            dum=dum.next;
        }
        return false;
    }
    public void reverseList(){
        SingleLinked next=null;
        SingleLinked curr=head;
        SingleLinked prev=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public int nNodeFromEnd(int pos){
        SingleLinked temp1=head,temp2=head;
        int count=0;
        while(count<pos){
            temp2=temp2.next;
            ++count;
        }
        while(temp2!=null){
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return temp1.data;
    }
    public void removeDuplicates(){
        SingleLinked dum=head,temp=head;
        while(dum.next!=null){
            if(dum.data==dum.next.data){
                dum.next=dum.next.next;
            }else{
                dum=dum.next;
            }
        }
    }
    public void insertSorted(int a){
        SingleLinked newData=new SingleLinked(a);
        SingleLinked temp=head;
        if(head.data>a){
            newData.next=head;
            head=newData;
            return;
        }
        while(temp.next!=null){
            if(a>=temp.data && a<=temp.next.data){
                newData.next=temp.next;
                temp.next=newData;
                return;
            }else{
                temp=temp.next;
            }
        }
        temp.next=newData;
    }
    public void deleteKey(int a){
        SingleLinked temp=head;
        SingleLinked prev=null;
        if(head.data==a){
            head=head.next;
            return;
        }
        while(temp!=null && temp.data!=a){
            prev=temp;
            temp=temp.next;
        }
        if(temp==null) return;
        prev.next=temp.next;

    }
    public SingleLinked loopFinder(){
        SingleLinked fastPtr=head;
        SingleLinked slowPtr=head;
        while(fastPtr.next!=null && fastPtr.next.next!=null){
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
            if(slowPtr==fastPtr){
                SingleLinked temp=head;
                while(temp.next!=slowPtr.next){
                    slowPtr=slowPtr.next;
                    temp=temp.next;
                }
                slowPtr.next=null;
                return temp;
            }
        }
        return null;
    }

    public SingleLinked sortThem(SingleLinked head2){
        SingleLinked mainHead=null;
        SingleLinked head1=head;
        if(head1.data<head2.data){
            mainHead=head1;
            head1=head1.next;
        }else{
            mainHead=head2;
            head2=head2.next;
        }
        SingleLinked tempHead=mainHead;
        while(head1!=null && head2!=null){

                if(head1.data<head2.data){
                    tempHead.next=head1;
                    head1=head1.next;
                }else{
                    tempHead.next=head2;
                    head2=head2.next;
                }
            tempHead=tempHead.next;
        }
        if(head1==null){
            tempHead.next=head2;
        }else if(head2 == null){
            tempHead.next=head1;
        }


        return mainHead;
    }
    public static void main(String[] args){
        SingleLinkedList m1=new SingleLinkedList();
        SingleLinkedList m2=new SingleLinkedList();
        m1.insertAtEnd(1);
        m1.insertAtEnd(3);
        m1.insertAtEnd(5);
        m1.insertAtEnd(9);

        m2.insertAtEnd(2);
        m2.insertAtEnd(4);
        m2.insertAtEnd(7);
        m2.insertAtEnd(9);
        m2.insertAtEnd(11);

        m1.display();
        m2.display();



    }
}