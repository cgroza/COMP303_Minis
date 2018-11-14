import java.util.Scanner;

// This class demonstrates how to use the system. It is not a demonstration of
// the full capabilities of the system. It only demonstrates what was required
// in the assignment.
public class Driver
{
    // The system supports multiple named orders, but for this demonstration we
    // will use a default one.
    public static final String DEFAULT_ORDER = "Order1";

    // Purpose: Reads a number from standard input.
    // Parameters: None
    // Returns: positive integer, or -1 if reading failed.
    // Side effects: Reads STDIN.
    public static int getNumber()
    {
        try {
            Scanner in = new Scanner(System.in);
            return in.nextInt();
        }
        catch(Exception e) {
            // Negative values are used as error values and will make the
            // program ask the question again
            return -1;
        }
    }

    // Purpose: Displays the menu and recovers a valid user choice.
    // Parameters: None
    // Returns: positive integer
    // Side effects: Reads STDIN.
    public static int menu()
    {
        // Print out menu.
        System.out.println("1) List items on menu.");
        System.out.println("2) Order a full meal.");
        System.out.println("3) Order a beer.");
        System.out.println("4) Order the Item of the Day (" + Menu.getMenu().getItemOfTheDay().getName() + ").");
        System.out.println("5) Look at order.");
        System.out.println("6) Pay order.");
        System.out.println("7) Quit.");

        // Read user choice.
        int choice = getNumber();
        // Keep trying until choice is valid.
        while(choice < 1 || choice > 7){
            System.out.println("Invalid choice.");
            choice = getNumber();
        }
        // Return when choice is valid.
        return choice;
    }

    public static void main(String[] args)
    {
        // Open an order with a default name. This is the order in which the
        // items will be placed.
        OrderingSystem.getSystem().newOrder(DEFAULT_ORDER);
        while(true)
            {
                switch(menu())
                    {
                    case 1:
                        // Print menu for the user.
                        System.out.println(Menu.getMenu().print());
                        break;
                    case 2:
                        // Order a full meal made of Guacamole, Giant Lobster
                        // and Cake. The system allows for different full meals
                        // given that the user is questioned on which items they
                        // wish and the appropriate FullMealItem is constructed.
                        OrderingSystem.getSystem().orderFullMeal(
                                                                 DEFAULT_ORDER,
                                                                 (ItemAppetizer) Menu.getMenu().getItemByName("Guacamole"),
                                                                 (ItemMainCourse) Menu.getMenu().getItemByName("Giant Lobster"),
                                                                 (ItemDessert) Menu.getMenu().getItemByName("Cake")
                                                                 );
                        break;
                    case 3:
                        // Add a beer to the current order.
                        OrderingSystem.getSystem().addItemToOrder(DEFAULT_ORDER, Menu.getMenu().getItemByName("Beer"));
                        break;
                    case 4:
                        // Add ItemOfTheDay to current order.
                        OrderingSystem.getSystem().addItemToOrder(DEFAULT_ORDER, Menu.getMenu().getItemOfTheDay());
                        break;
                    case 5:
                        // Print the contents of the order.
                        System.out.println(DEFAULT_ORDER + ":");
                        System.out.println(OrderingSystem.getSystem().getOrderByName(DEFAULT_ORDER).print());
                        System.out.println();
                        break;
                    case 6:
                        // Close old order and open a new empty one.
                        Order order = OrderingSystem.getSystem().getOrderByName(DEFAULT_ORDER);
                        System.out.println("Charged: " + order.getTotal());
                        OrderingSystem.getSystem().closeOrder(DEFAULT_ORDER);
                        OrderingSystem.getSystem().newOrder(DEFAULT_ORDER);
                        break;
                    case 7:
                        System.exit(0);
                        break;
                    }
            }
    }
}
