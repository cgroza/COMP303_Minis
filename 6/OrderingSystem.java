import java.util.HashMap;

public class OrderingSystem
{
    // Reference to the singleton OrderingSystem object.
    private static final OrderingSystem orderingSystem = new OrderingSystem();
    // Stores the menu from which items are picked.
    private Menu menu;
    // Database of orders
    private HashMap<String, Order> orders;
    // Singleton class.
    private OrderingSystem()
    {
        menu = Menu.getMenu();
        orders = new HashMap<String, Order>();
    }

    public static OrderingSystem getSystem() {
        return orderingSystem;
    }

    public Order newOrder(String orderName)
    {
        // Create new order. Overwrite old orders.
        return orders.put(orderName, new Order());
    }

    public Order getOrderByName(String orderName)
    {
        // Create new order. Overwrite old orders.
        return orders.get(orderName);
    }

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

    public FullMealItem orderFullMeal(String orderName, ItemAppetizer app, ItemMainCourse main, ItemDessert dessert)
    {
        FullMealItem fullMeal = new FullMealItem(app, main, new ItemDiscount(dessert, dessert.getCategory(), 0.5));
        addItemToOrder(orderName, fullMeal);
        return fullMeal;
    }

    public ItemIterator listItems()
    {
        return menu.getItemIterator();
    }
}
