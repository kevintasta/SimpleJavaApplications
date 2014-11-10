import java.util.Collections;
import java.text.NumberFormat;
import java.util.Queue;
import java.util.Set;
/**
* Represents an abstract pizzeria that has the ability
* to take and process customer orders.
*
* @author Yuanhan Pan
* @version 1.0
**/
public abstract class AbstractPizzeria implements Pizzeria {

    private Set<Order> menu;
    protected double ordersReceived = 0, deliveryAttempts = 0,
    deliverySuccesses = 0, totalRevenue = 0;
    protected String name;
    protected Queue<Customer> customers;

    /**
    * Creates an instance of a Pizzeria with a given menu
    * @param  menu  a Set of Orders that serves as the Pizeeria's
    *               menu
    **/
    public AbstractPizzeria(Set<Order> menu) {
        this.menu = menu;
    }

    /**
     * Tells the pizzeria to place an order with a Customer
     *
     * @param customer Customer who wants a pizza
     */
    public void placeOrder(Customer customer) {
        customers.add(customer);
        ordersReceived++;
    }

    /**
     * Returns the cheapest menu item based on price
     *
     * @return cheapest menu item
     */
    public Order getCheapestMenuItem() {
        return Collections.min(menu);
    }

    /**
     * Returns the most expensive menu item based on price
     *
     * @return most expensive menu item
     */
    public Order getMostExpensiveMenuItem() {
        return Collections.max(menu);
    }


    /**
     * Status message of a Pizzeria's performance
     * Returns what percentage of orders have been delivered
     * and what percentage of attempted orders have been delivered
     * along with total revenues
     *
     * @return Message string
     */
    public String status() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return "We delivered "
            + (int) Math.round(100 * (deliverySuccesses / ordersReceived))
            + "% of our orders! We delivered "
            + (int) Math.round(100 * (deliverySuccesses / deliveryAttempts))
            + "% of our attempted orders and made "
            + formatter.format(totalRevenue);

    }

    /**
     * Pizzeria name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Delivers an order to a customer.
     * If the customer placed an order that's not on the menu,
     * ther order is not delivered. If the customer placed an order that is
     * on the menu but doesn't have enough money to pay,
     * the order is not delivered. Otherwise, the order is processed
     * and the Customer's money is collected.
     */
    public void processOrder() {
        Customer currentCustomer = customers.remove();
        deliveryAttempts++;
        if (menu.contains(currentCustomer.getOrder())
                && currentCustomer.canPay()) {
            deliverySuccesses++;
            totalRevenue += currentCustomer.getOrder().getPrice();
        }
    }
}