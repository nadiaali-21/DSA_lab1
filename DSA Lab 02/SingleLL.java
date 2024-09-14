package singlell;

public class SingleLL {

    int size=0;
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
            size++;          
        }
}
        private Node head;
        private Node tail =null;
       SingleLL(){
       head=tail;
       } 
public void insertfirst(int data){
    Node newnode=new Node(data);
    newnode.next=head;
    head=newnode;
}
public void insertlast(int data){
    Node newnode=new Node(data);
    Node curnode=head;
    while(curnode.next!=null){
        curnode=curnode.next;
    }
    curnode.next=newnode;
}
public void insertmiddle(int data,int position){
    Node newnode=new Node(data);
    if (position == 0){
    newnode.next = head;
    head = newnode;
}else{ Node current = head;
    for(int i = 0; i<position-1 ; i++){
    current  = current.next;
    }
    newnode.next = current.next;
    current.next = newnode;
    }
    
}
public void deletefirst(){
    Node current=head;
   head=current.next;
   size--;
    }

public void deletelast(){
Node seclast=head;
    Node last=head.next;

    while(last.next!=null){
       last=last.next;
       seclast=seclast.next;
    }
      seclast.next=null;
size--;}
  public void deleteByValue(int value) {
    Node current = head;
    Node previous = null;

    while (current != null) {
        if (current.data == value) {
            if (previous == null) {
                head = current.next;
            }else{
                previous.next=current.next;
            }
            System.out.println("Deleted");
            size--;
            return;
        }
        previous = current;
        current = current.next;
    }
    System.out.println("Not found");
      }       

public void print(){
    Node current=head;
    while(current!=null){
        System.out.print(current.data+"->");
        current=current.next;
    }
    System.out.println("NULL");
 }
void Search(int data){
    if(head==null){
        System.out.println("Not found");
    return;}
boolean flag = false;
Node curNode = head;
while(curNode!=null){
curNode = curNode.next;
if(curNode.data==data){
flag = true;
break;
}
}
if(flag == true){

    System.out.println("Found");
}else{
    System.out.println("Not found");
}

}

    public static void main(String[] args) {
     SingleLL list =  new SingleLL();
      list.insertfirst(3);
      list.insertfirst(2);
      list.insertfirst(1);
      list.insertlast(6);
      
       list.print();
        System.out.println("size of list : "+list.size);
        list.Search(2);
        list.insertmiddle(10, 2);
        
        list.print();
        list.deleteByValue(1);
        list.print();
        list.insertlast(15);
        list.print();
        System.out.println("Total nodes in List : "+list.size);
        
    }
    
}