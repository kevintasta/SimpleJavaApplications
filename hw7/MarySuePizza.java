import java.util.PriorityQueue;
import java.util.Set;
/**
* A pizzeria that processes all Customer Orders by
* the price of the orders.
*
* @author Yuanhan Pan
* @version 1.0
**/
public class MarySuePizza extends AbstractPizzeria {

    /**
    * Creates a new MarySuePizza object with a specified menu
    * and a PriorityDeque of Customers to process Orders.
    * @param  menu  the Set of Orders that represents this
    *               Pizzeria's menu
    **/
    public MarySuePizza(Set<Order> menu) {
        super(menu);
        name = "Mary Sue Pizza";
        customers = new PriorityQueue<Customer>();
    }
}