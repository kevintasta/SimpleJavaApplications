/**
* Customer class that places Orders in Pizzerias.
*
* @author Yuanhan Pan
* @version 1.0
**/
public class Customer implements Comparable<Customer> {

    private int money;
    private Order order;

    /**
    * Creates a new Customer with a passed in Order and a Random amount of
    * money from $5 to $34.
    * @param  order  the Customer's passed in Order
    **/
    public Customer(Order order) {
        this.order = order;
        money = Driver.RANDOM.nextInt(30) + 5;
    }

    /**
    * Compares this Customer to another Customer based on the price of their
    * Orders
    * @param  other  the Customer to be compared to
    * @return        a negative int if the price of this Customer's Order is
    *                greater, a positive int if this price is smaller, 0 if the
    *                prices are the same
    **/
    public int compareTo(Customer other) {
        return other.order.getPrice() - this.order.getPrice();
    }

    public int compare(Customer a, Customer b) {
        if (a.canPay() && !b.canPay()) {
            return -1;
        } else if (b.canPay() && !a.canPay()) {
            return 1;
        } else {
            return a.compareTo(b);
        }
    }

    /**
    * Specifies if this Customer has enough money to pay for the Order
    * @return  whether the Customer's money is greater or equal to the
    *          price of the order
    **/
    public boolean canPay() {
        return money >= order.getPrice();
    }

    /**
    * Gets the Customer's Order.
    * @return  the Customer's Order
    **/
    public Order getOrder() {
        return order;
    }

    /**
    * Gets the Customer's money.
    * @return  the amount of money the Customer has
    **/
    public int getMoney() {
        return money;
    }


}