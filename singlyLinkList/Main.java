package singlyLinkList;

import java.util.LinkedList;

public class Main {
  
    public static void main(String[] args) {
        
        Linklist linkedList = new Linklist();
        linkedList.insertFirst(10);
        linkedList.insertFirst(20);
        linkedList.insertAtPosition(55, 0);
        linkedList.insertEnd(75);
        linkedList.deleteFirst();
        linkedList.printData();
    }
}
