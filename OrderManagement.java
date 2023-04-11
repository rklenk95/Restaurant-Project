import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class OrderManagement {
    static private Queue<Order> ordersPlaced; //Queue of orders placed


    public OrderManagement() {
        ordersPlaced = new LinkedList<>();
    }

    /**
     Adds a order to the orders placed
     @param Order o - the order object to be added
     */

    public void addOrder(Order o) {
        ordersPlaced.add(o);

    }

    /**
     Drops a order from order placed by removing the order at the head of the queue
     @param int orderID - the orderID of order to be served/removed
     */

    public void serveCustomer(){
        System.out.println("Order " + ordersPlaced.peek().getOrderID() + " has been served");
        ordersPlaced.remove();
        System.out.println();
    }

    /**
     Prints all orders from orders placed
     */

    public void printOrders()
    {
        System.out.print("Orders: \n" +
                "-----------------------------\n");
        Iterator<Order> itr = ordersPlaced.iterator();
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }
        System.out.println();

    }

}
