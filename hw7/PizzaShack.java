import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
/**
* A pizzeria that processes all Customer Orders by
* the Customer's ability to pay and the price of the orders.
*
* @author Yuanhan Pan
* @version 1.0
**/
public class PizzaShack extends AbstractPizzeria {

    /**
    * Creates a new PizzaShack object with a specified menu
    * and a PriorityDeque of Customers to process Orders.
    * @param  menu  the Set of Orders that represents this
    *               Pizzeria's menu
    **/
    public PizzaShack(Set<Order> menu) {
        super(menu);
        name = "Pizza Shack";
        Comparator<Customer> customerComparator = new Comparator<Customer>() {
            public int compare(Customer a, Customer b) {
                if (a.canPay() && !b.canPay()) {
                    return -1;
                } else if (b.canPay() && !a.canPay()) {
                    return 1;
                } else {
                    return a.compareTo(b);
                }
            }
        };
        customers = new PriorityQueue<Customer>(customerComparator);
    }
}