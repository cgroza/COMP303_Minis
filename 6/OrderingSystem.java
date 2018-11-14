import java.util.HashMap;

// This class is manages the menu and a database of orders. It is a singleton.
public class OrderingSystem
{
    // Reference to the singleton OrderingSystem object.
    private static final OrderingSystem orderingSystem = new OrderingSystem();
    // Stores the menu from which items are picked.
    private Menu menu;
    // Database of orders indexed by name.
    private HashMap<String, Order> orders;

    // Purpose: Constructs the unique OrderingSystem instance. Singleton class.
    // Returns: The OrderingSystem.
    private OrderingSystem()
    {
        menu = Menu.getMenu();
        orders = new HashMap<String, Order>();
    }

    // Purpose: Getter for the unique instance of this class.
    // Returns: The OrderingSystem.
    public static OrderingSystem getSystem() {
        return orderingSystem;
    }

    // Purpose: Open a new order and adds to the database of orders by name.
    // Overwrites if names collide.
    // Parameters: orderName - the name under which the order to be created.
    // Returns: The newly created order.
    public Order newOrder(String orderName)
    {
        // Create new order. Overwrite old orders.
        return orders.put(orderName, new Order());
    }

    // Purpose: Retrieve an order from the database by name.
    // Parameters: orderName - the name of the order.
    // Returns: null if not found, the order if found.
    public Order getOrderByName(String orderName)
    {
        return orders.get(orderName);
    }

    // Purpose: Add an item  to the order with orderName index.
    // Parameters: order Name - the name of the order
    //             item - the item to be added to the order
    // Returns: null if order was not found, or the order that modified.
    public Order addItemToOrder(String orderName, Item item)
    {
        // If order is opened, add item.
        if(orders.containsKey(orderName))
            {
                orders.get(orderName).orderItem(item);
                return orders.get(orderName);
            }
        // If no such order found, then return null.
        else return null;
    }

    // Purpose: Mark this item as closed.
    // Parameters: orderName - the name of the order to be closed.
    // Returns: null if order was not found, or the order that modified.
    public Order closeOrder(String orderName)
    {
        // If order is opened, close it and return it.
        if(orders.containsKey(orderName))
            {
                Order order = orders.get(orderName);
                order.close();
                orders.remove(orderName);
                return order;
            }
        // If no such order found, then return null.
        else return null;
    }

    // Purpose: Construct a FullMeal item from its parts and add it to the order.
    // Parameters: orderName - the order to add full meal to
    //             app - the appetizer of the full meal
    //             main - the main course of the full meal
    //             dessert - the not yet discounted dessert of the full meal
    // Returns: the newly created full meal.
    public FullMealItem orderFullMeal(String orderName, ItemAppetizer app, ItemMainCourse main, ItemDessert dessert)
    {
        FullMealItem fullMeal = new FullMealItem(app, main,
                                                 // Create the discounted dessert..
                                                 new ItemDiscount(dessert, dessert.getCategory(), 0.5));
        addItemToOrder(orderName, fullMeal);
        return fullMeal;
    }

    // Purpose: Allows listing of items via the ItemIterator of the menu.
    // Returns: The iterator to the menu.
    public ItemIterator listItems()
    {
        return menu.getItemIterator();
    }
}
