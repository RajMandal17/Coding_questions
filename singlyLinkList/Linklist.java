package singlyLinkList;


public class Linklist {

    Node head = null;

    public void insertFirst(int data){
        Node newNode = new Node(data);

        if(head == null ){
           head =  newNode;
           return ;
        }
       //if already nodes are there then point head to this node and place there adress to next
        newNode.next = head;
        head = newNode;

    } 

    public void insertEnd(int data){
       Node newNode = new Node(data);
        if(head == null ){
           head = newNode;
           return ;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;

    }

    public void insertAtPosition(int data , int position){
        
        Node newNode = new Node(data);
        if (position < 0){
            System.out.println("Invalid position");
            return;
        }
        if(position == 0){
            insertFirst(data);
            return; 
        }
 
        Node temp = head;                       //example:           
  while(temp.next != null && position > 1){  //  [2,56,78,90] position = 2
            temp = temp.next;                //  temp = head.next;  //  [56,78,90] position = 1
            position--;                      //  temp = head.next.next;  //  [78,90] position = 0
        }
        if(temp.next == null){
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        }

        public void deleteFirst(){
            if(head == null){
                System.out.println("Empty linklist");
                return ;
            }
            Node newNode = head.next;
            head = newNode;
        }

        public void deleteLast(){

            if(head == null ){
                System.out.println("LinkedList is empty");
                return;
            }
            if(head.next== null ){
                head=null;
                return;
            }
            Node currNode = head;
            while(currNode.next == null){
                currNode = currNode.next;
            } 

            currNode.next = null;
        }

        public void printData(){

            if (head == null){
                System.out.println("linklist is empty : ");
                return;
            }
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            
        }


}
