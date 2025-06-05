import java.util.Date;

class Order {
    String orderId;
    double price;
    double quantity;
    long timestamp;

    public Order(String orderId, double price, double quantity) {
        this.orderId = orderId;
        this.price = price;
        this.quantity = quantity;
        this.timestamp = new Date().getTime();
    }
}

class PriceLevelLinkedList {
    Node head;
    Node tail;  // For O(1) insertions at end

    class Node {
        Order order;
        Node next;

        Node(Order order) {
            this.order = order;
            this.next = null;
        }
    }

    public void insertEnd(Order order) {
        Node newNode = new Node(order);
        if (tail == null) {
            head = tail = newNode;      // If list is empty, head and tail point to new node
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Order deleteFirst() {
        if (head == null) return null;
        
        Node temp = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return temp.order;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Order peekFirst() {
        return head != null ? head.order : null;
    }
}

class PriceLevel {
    private final double price;
    private final PriceLevelLinkedList orders = new PriceLevelLinkedList();

    public PriceLevel(double price) {
        this.price = price;
    }

    public void addOrder(Order order) {
        orders.insertEnd(order);
        System.out.println("Added order " + order.orderId + " @ " + price);
    }

    public void matchOrder(double quantityToMatch) {
        System.out.println("\nMatching " + quantityToMatch + " BTC @ " + price);
        
        while (quantityToMatch > 0 && !orders.isEmpty()) {
            Order currentOrder = orders.peekFirst();
            
            if (currentOrder.quantity <= quantityToMatch) {
                // Full fill
                System.out.println("Matched order: " + currentOrder.orderId 
                    + ", Qty: " + currentOrder.quantity);
                quantityToMatch -= currentOrder.quantity;
                orders.deleteFirst();
            } else {
                // Partial fill
                System.out.println("Partially matched order: " + currentOrder.orderId 
                    + ", Qty: " + quantityToMatch);
                currentOrder.quantity -= quantityToMatch;
                quantityToMatch = 0;
            }
        }
    }
}

public class MatchEngineDemo {
    public static void main(String[] args) throws InterruptedException {
        // Create a price level for $50,000 BTC bids
        PriceLevel bidPriceLevel = new PriceLevel(50000);
        
        // Add buy orders (should execute in FIFO order)
        bidPriceLevel.addOrder(new Order("order1", 50000, 1.0));
        Thread.sleep(1); // Force different timestamps
        bidPriceLevel.addOrder(new Order("order2", 50000, 2.0));
        Thread.sleep(1);
        bidPriceLevel.addOrder(new Order("order3", 50000, 0.5));

        // Simulate market sell order for 3.5 BTC
        bidPriceLevel.matchOrder(3.5);
    }
}