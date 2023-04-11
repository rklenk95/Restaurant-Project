public class Order
{
    private int orderID;    // order ID
    private String menuItemName;  // menu item name
    

    // Order class constructor
    public Order(int orderID, String menuItemName)
    {
        this.orderID = orderID;
        this.menuItemName = menuItemName;
    }

    public int getOrderID() {
        return orderID;
    }

    @Override
    public String toString() {
        return "ID- " + orderID + "\t" + "Menu Item- " + menuItemName;
    }
}