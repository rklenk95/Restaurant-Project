/**
 * @author Ryan Klenk
 * @version 12/13/20
 */

import java.util.ArrayList;
import java.util.Scanner;

public class MenuDriver {

    /**
     Initialize objects of Menu and OrderManagement
     - To access their methods
     */

    Menu menu = new Menu();
    OrderManagement order = new OrderManagement();

    //Initializes arrays to keep track of used IDs

    ArrayList<Integer> usedMenuID = new ArrayList<Integer>();
    ArrayList<Integer> usedOrderID = new ArrayList<Integer>();


    /*Adds a new MenuItems object based on default values
    Adds the IDs used in default items to the usedMenuID array
    */

    public void addDefaultMenuItems()
    {
        menu.addDefaultMenuItems();
        for(int i = 1; i <= 4; i++)
        {
            usedMenuID.add(i);
        }

    }

    /**
     Adds a new MenuItems object based on user input.
     @param in - the Scanner to read from.
     */

    public void addMenuItem(Scanner in) {
        boolean validID = false;
        System.out.print("Enter menu item ID: ");
        int itemID = in.nextInt();
        while (!validID) {
            if (!usedMenuID.contains(itemID)) {
                validID = true;
                usedMenuID.add(itemID);
            } else {
                validID = false;
                System.out.print("Error, please enter an unused menu item ID: ");
                itemID = in.nextInt();

            }
        }
        in.nextLine();
        System.out.print("Enter item's name: ");
        String itemName = in.nextLine();
        System.out.print("Enter item's price: ");
        double price = in.nextDouble();

        System.out.print("Enter item's calories: ");
        int calories = in.nextInt();


        MenuItems m = new MenuItems(itemID, itemName, price, calories);
        menu.addMenuItem(m);
    }

    /**
     Method to remove MenuItems from menu.
     @param in - the Scanner to read menu item ID of the item to be removed.
     */

    public void removeMenuItem(Scanner in)
    {
        System.out.print("Enter a menu item's ID to remove it from the menu: ");
        int itemID = in.nextInt();
        for(int i = 0; i < usedMenuID.size(); i++)
            if (usedMenuID.get(i).equals(itemID))
            {
                usedMenuID.remove(i);

            }
        menu.removeMenuItem(itemID);

    }

    /**
     Method to print MenuItems from the menu
     */

    public void printMenu()
    {
        menu.printMenu();
        System.out.println();
    }

    /**
     Adds a new Order object based on user input to the queue.
     @param in - the Scanner to read from.
     */

    public void takeOrder(Scanner in) {
        boolean validID = false;
        System.out.print("Enter order ID: ");
        int orderID = in.nextInt();
        while (!validID) {
            if (!usedOrderID.contains(orderID)) {
                validID = true;
                usedOrderID.add(orderID);
            } else {
                System.out.print("Error, please enter an unused order ID: ");
                orderID = in.nextInt();

            }
        }
        in.nextLine();
        System.out.print("Enter name of menu item: ");
        String itemName = in.nextLine();

        Order o = new Order(orderID, itemName);
        order.addOrder(o);
        System.out.println();
    }

    /*
    Method to serve/remove the first customer in the queue
     */
    public void serveCustomer(){
        order.serveCustomer();

    }

    /**
     Method to print Orders
     */
    public void printOrders(){
        order.printOrders();

    }

    /**
     Method to print the Menu for the user options
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        MenuDriver m = new MenuDriver();
        MenuDriver o = new MenuDriver();

        m.addDefaultMenuItems();

        System.out.println("Welcome to Friendly's");
        System.out.println("--------------------------------");

        boolean done = false;
        while (!done)
        {
            System.out.print("Menu Options\n(V)iew Menu, (A)dd item to menu, (R)emove item from menu" +
                    "\n(T)ake Order, (S)erve Customer, (D)isplay Orders\n(Q)uit: ");
            String choice = in.next();
            System.out.println();

            if (choice.equals("V") || choice.equals("v"))
            {
                m.printMenu();
            }
            else if (choice.equals("A") || choice.equals("a"))
            {
                m.addMenuItem(new Scanner(System.in));
                System.out.println();
            }
            else if (choice.equals("R") || choice.equals("r"))
            {
                m.removeMenuItem(new Scanner((System.in)));
                System.out.println();
            }
            else if (choice.equals("T") || choice.equals("t"))
            {
                o.takeOrder(new Scanner((System.in)));
            }
            else if (choice.equals("S") || choice.equals("s"))
            {
                o.serveCustomer();
            }
            else if (choice.equals("D") || choice.equals("d"))
            {
                o.printOrders();
            }
            done = choice.equals("Q") || choice.equals("q");
        }
        System.out.println("Program ended");
        in.close();
    }
}
