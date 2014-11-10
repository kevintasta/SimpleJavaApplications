import java.util.ArrayDeque;
import java.util.Set;
/**
* A pizzeria that processes all Customer Orders in
* the order they were placed.
*
* @author Yuanhan Pan
* @version 1.0
**/
public class CascadePizza extends AbstractPizzeria {

    /**
    * Creates a new CascadePizza object with a specified menu
    * and an ArrayDeque of Customers to process Orders.
    * @param  menu  the Set of Orders that represents this
    *               Pizzeria's menu
    **/
    public CascadePizza(Set<Order> menu) {
        super(menu);
        name = "Cascade Pizza";
        customers = new ArrayDeque<Customer>();
    }
}