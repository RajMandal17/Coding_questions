public class implementLinklist {
    
    node head; // Head of the linked list
    
    class node{
        String data;
        node next;


        node(String data){
            this.data = data;
            this.next = null;
        }

    }
    //add operation   (first or last)
    public void addFirst(String data){
         node newNode = new node(data);
          if(head == null ){
            head = newNode;
            return ;
          }

          newNode.next = head;
          head = newNode;
    }

    public void addLast(String data){
        node newNode = new node(data);
        if(head == null){
            head = newNode;
            return;
        }
        node currentNode = head;
        while (currentNode.next != null ) {
            currentNode = currentNode.next;    
            }
            currentNode.next = newNode;
        }

        public void printList(){
            if(head == null){
                System.out.println("List is empty");
                return;
            }
            node CurrentNode = head;
            while(CurrentNode != null){
                System.out.print(CurrentNode.data + " ");
                CurrentNode = CurrentNode.next;
            }

        }

        // Function to delete the first node
        public void deleteFirst() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            head = head.next;
        }

        // Function to delete the last node
         
        public void deleteLast() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            if (head.next == null) {
                head = null;
                return;
            }
            node currentNode = head;
            while (currentNode.next.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = null;
        }

        // Function to delete a node at a specific position
        public void deleteAtPosition(int position) {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            if (position == 0) {
                head = head.next;
                return;
            }
            node currentNode = head;
            for (int i = 0; i < position - 1 && currentNode != null; i++) {
                currentNode = currentNode.next;
            }
            if (currentNode == null || currentNode.next == null) {
                System.out.println("Position out of bounds");
                return;
            }
            currentNode.next = currentNode.next.next;
        }

    public static void main(String[] args) {
        implementLinklist list = new implementLinklist();
        list.addFirst("raj");
      //  list.addFirst("kumar");
        list.addLast("Dev");

        list.printList();
    }
}
