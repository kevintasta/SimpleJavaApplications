import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * An implementation of the FunctionalSortedSet interface that uses an ArrayList
 * as the backing data structure.
 *
 * @author Joe Rossi, Yuanhan Pan
 * @version 1.0, 1.1
 * @param <E> A comparable object that is contained within this sorted set.
 */
public class MySortedSet<E extends Comparable<? super E>>
    implements FunctionalSortedSet<E> {

    private ArrayList<E> list;
    private Comparator<E> c;

    /**
     * Creates a MySortedSet using the Comparable's compareTo as Comparator
     */
    public MySortedSet() {
        this(
            (a, b) -> a.compareTo(b)
            );
    }

    /**
     * Creates a MySortedSet using a specific Comparator
     *
     * @param c a Comparator that either "has" or "is" one int valued method
     */
    public MySortedSet(Comparator<E> c) {
        this.c = c;
        list = new ArrayList<E>();
    }

    //-----------FunctionalSortedSet METHODS - ONLY MODIFY filter!!------------

    /**
    * Filters a MySortedSet with a specific Predicate.
    * @param  p  the Predicate used to filter the MySortedSet
    * @return    a new MySortedSet from the original MySortedSet after being
    *            filtered through the Predicate
    **/
    @Override
    public MySortedSet<E> filter(Predicate<E> p) {
        return list.stream().filter(p).collect(
            Collectors.toCollection(() -> new MySortedSet<E>(c)));
    }

    /**
    * Sorts the MySortedSet using a specific Comparator
    * @param  comparator  the Comparator used to sort the MySortedSet
    * @return             a new MySortedSet sorted by comparator
    **/
    @Override
    public MySortedSet<E> sort(Comparator<E> comparator) {
        MySortedSet<E> ret = new MySortedSet<E>(comparator);
        ret.addAll(this.list);
        return ret;
    }

    //------SortedSet METHODS - ONLY MODIFY subSet and tailSet!!---------------

    /**
    * Gets the MySortedSet's comparator.
    * @return  the MySortedSet's Comparator
    **/
    @Override
    public Comparator<? super E> comparator() {
        return c;
    }

    /**
    * Gets the first element in a MySortedList.
    * @retrun  the first element of a MySortedList
    **/
    @Override
    public E first() {
        return list.get(0);
    }

    /**
     * Returns a MySortedSet object with all elements [first, toElement] using a
     * functional programming expression.
     *
     * @param toElement The element the returned set should stop before.
     * @return A sorted set containing elements strictly less than toElement.
     */
    @Override
    public MySortedSet<E> headSet(E toElement) {
        return list.subList(0, list.indexOf(toElement)).stream().collect(
                        Collectors.toCollection(() -> new MySortedSet<>(c)));
    }

    /**
     * Return a MySortedSet object with all elements [fromElement, toElement]
     * using a functional programming expression.
     *
     * @param fromElement The first element the returned set should contain.
     * @param toElement The element the returned set should stop before.
     * @return A sorted set containing elements fromElement to toElement.
     */
    @Override
    public MySortedSet<E> subSet(E fromElement, E toElement) {
        return list.subList(list.indexOf(fromElement),
            list.indexOf(toElement)).stream().collect(
            Collectors.toCollection(() -> new MySortedSet<>(c)));
    }

    /**
     * Return a MySortedSet object with all elements [fromElement, last]
     * using a functional programming expression.
     *
     * @param fromElement The first element the returned set should contain.
     * @return A sorted set containing elements fromElement and onwards.
     */
    @Override
    public MySortedSet<E> tailSet(E fromElement) {
        return list.subList(list.indexOf(fromElement),
                list.size()).stream().collect(
                Collectors.toCollection(() -> new MySortedSet<>(c)));
    }

    /**
    * Gets the last element in a MySortedList
    * @return  the last element in a MySortedLIst
    **/
    @Override
    public E last() {
        return list.get(list.size() - 1);
    }

    /**
    * Adds the specified element to a MySortedList.
    * @param  e  the element to be added
    * @return    if the element is unique and successfully
    *            added to the MySortedList
    **/
    @Override
    public boolean add(E e) {
        if (e != null && !(this.contains(e))) {
            list.add(e);
            list.sort(c);
            return true;
        }
        return false;
    }

    /**
    * Removes the specified element from a MySortedList.
    * @param  e  the element to be removed
    * @return    if the element was successfully removed
    **/
    @Override
    public boolean remove(Object e) {
        return list.remove(e);
    }

    /**
    * Specifies if a MySortedList contains a specific element
    * @param  e  the element to be checked
    * @return    whether the MySortedList contains e
    **/
    @Override
    public boolean contains(Object e) {
        return list.contains(e);
    }

    /**
    * Specifies if a MySortedList cotains a collection of specific elements
    * @param  col  the collection of elements to be checked
    * @param       whether the MySortedList contains col
    **/
    @Override
    public boolean containsAll(Collection<?> col) {
        return list.containsAll(col);
    }

    /**
    * Specifies if a MySortedList is empty
    * @return  whether a MySortedList is empty
    **/
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
    * Gets the size of a MySortedList
    * @return   the number of elements in the MySortedList
    **/
    @Override
    public int size() {
        return list.size();
    }

    /**
    * Adds a specified collection of elements to a MySortedList
    * @param  col  the collection of elements to be added
    * @return      whether MySortedList changed as a result of the call
    **/
    @Override
    public boolean addAll(Collection<? extends E> col) {
        int temp = list.size();
        for (E e : col) {
            add(e);
        }
        return list.size() > temp;
    }

    /**
    * Removes a specified collection of elements from a MySortedList
    * @param  col  the collection of elements to be removed
    * @return      whether col was successfully removed from the MySortedList
    **/
    @Override
    public boolean removeAll(Collection<?> col) {
        return list.removeAll(col);
    }

    /**
    * Retains only the elements in this MySortedSet that are contained in
    * the specified collection.
    * @param  col  collection containing elements to be retained
    * @return      true if this MySortedList changed as a result of the
    *              call
    **/
    @Override
    public boolean retainAll(Collection<?> col) {
        return list.retainAll(col);
    }

    /**
    * Returns an iterator over the elements in this MySortedList
    * @return an iterator over the elements in this MySortedList
    **/
    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    /**
    * Removes all elements from this MySortedList
    **/
    @Override
    public void clear() {
        list.clear();
    }

    /**
    * Produces an array conataining all of the elements in this MySortedList
    * @return  an array containing all of the elements in this MySortedLIst
    **/
    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    /**
    * Returns an array of all of the elements in this MySortedList with the
    * array's type being the runtime type of the array
    * @param  T  the runtime type of the array
    * @param  a  the array in which the elements of the MySortedList are to
    *            to be stored
    * @return    an array containing elements of the list
    **/
    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    /**
    * Gets a string representation of this MySortedList with each element in
    * the MySortedList being displayed on a new line.
    * @return  the string representation of this MySortedList
    **/
    @Override
    public String toString() {
        String represenation = "";
        for (E e : list) {
            represenation += e + "\n";
        }
        return represenation;
    }
}
