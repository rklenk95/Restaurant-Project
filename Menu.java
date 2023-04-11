import java.util.LinkedList;

public class Menu {
    private final LinkedList<MenuItems> menu; //Collection of MenuItems objects

    public Menu()
    {
        menu = new LinkedList<>();
    }

    /**
     Adds default menu items to the menu
     */

    public void addDefaultMenuItems()
    {
        MenuItems m = new MenuItems(1,"Chicken Fingers", 11.99, 400);
        menu.add(m);
        m = new MenuItems(2,"Burger", 11.99, 500);
        menu.add(m);
        m = new MenuItems(3,"Salad", 6.99, 100);
        menu.add(m);
        m = new MenuItems(4,"Coke", 3.99, 200);
        menu.add(m);
    }

    /**
     Adds a menu item to the menu
     @param MenuItems m - the MenuItems object to be added
     */
    public void addMenuItem(MenuItems m)
    {
        menu.add(m);

    }

    /**
     Removes a menu item from menu
     @param int itemID - the itemID of menuItem to be removed
     */

    public void removeMenuItem(int itemID) {
        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).getItemID() == itemID) {
                menu.remove(i);
                System.out.println("Menu item " + itemID + " has been removed from the menu");
            }
        }
    }

    /**
     Prints all menu items on the menu
     */

    public void printMenu()
    {
        System.out.print("Menu: \n" +
                "-----------------------------\n");

        for(int i = 0; i < menu.size(); i++)
            System.out.println(menu.get(i));

    }
}
