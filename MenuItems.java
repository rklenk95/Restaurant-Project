public class MenuItems
{
    private int itemID;    // item ID
    private String itemName;  // item name
    private double price;   // price
    private int calories;    //calories

    // MenuItems class constructor
    public MenuItems(int itemID, String itemName, double price, int calories) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.price = price;
        this.calories = calories;
    }

    public int getItemID() {
        return itemID;
    }

    @Override
    public String toString() {
        String formattedString = String.format("%-8s %-25s %-20s %-1s %-10s", "ID-" + itemID, "Name-" + itemName, "Price-$" + price, "", "Calories-" + calories);
        return formattedString;
    }
}

