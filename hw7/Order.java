import java.util.HashSet;
/**
* Represents a pizza order and
* contains a collection of Ingredients.
*
* @author Yuanhan Pan
* @version 1.0
**/
public class Order extends HashSet<Ingredient> implements Comparable<Order> {

    /**
    * Default constructor for Order that calls on the
    * HashSet super constructor.
    **/
    public Order() {
        super();
    }

    /**
    * Returns the price of the order by summing the cost of the indvidual
    * Ingredients.
    * @return  the price of the order
    **/
    public int getPrice() {
        int price = 0;
        for (Ingredient ingredient : this) {
            price += ingredient.getPrice();
        }
        return price;
    }

    /**
    * Compares the current Order to another order using the Order's price.
    * @param  other  Order to be compared to
    * @return        a positive int if this Order's price is greater,
    *                a negativem int if this Order's price is lower,
    *                0 if this Order's price is the same
    *
    **/
    public int compareTo(Order other) {
        return getPrice() - other.getPrice();
    }
}