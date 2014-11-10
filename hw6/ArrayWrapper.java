import java.util.NoSuchElementException;
/**
 * A simple collection class that implements the SimpleCollection
 * interface.
 * @author Yuanhan Pan
 * @version 1.0
 */
public class ArrayWrapper<T> implements SimpleCollection<T> {

    private int elementCount = 0, size = 5;
    private T[] genericArray = (T[]) new Object[size];

    /**
     * Adds an element into the collection.
     * If the new element exceeds the size of the backing array,
     * the elements of the backing array are copied into a new
     * array with a size equal to double the backing array.
     *
     * @param elem The element being added.
     */
    public void add(T elem) {
        if (elementCount >= size) {
            T[] temp = (T[]) new Object[size * 2];
            for (int i = 0; i < size; i++) {
                temp[i] = genericArray[i];
            }
            genericArray = temp;
            size = size * 2;
        }
        genericArray[elementCount] = elem;
        elementCount++;
    }

    /**
     * Adds all elements in elems to the collection.
     *
     * @param elems Array of elements to be added.
     */
    public void addAll(T[] elems) {
        for (T element : elems) {
            add(element);
        }
    }

    /**
     * Removes elem from the collection. Removing the element
     * shifts all the elements behind it forward, ensuring
     * that the backing array is contiguous.
     *
     * @param elem Element to be removed.
     * @return true if the element was removed,
     *         false if it was not in the collection.
     */
    public boolean remove(T elem) {
        if (contains(elem)) {
            elementCount--;
            for (int i = indexOf(elem); i < elementCount; i++) {
                genericArray[i] = genericArray[i + 1];
            }
            for (int i = elementCount; i < size; i++) {
                genericArray[i] = null;
            }
            return true;
        }
        return false;
    }

    /**
     * Removes each element in elems from the collection.
     *
     * @param elems Array of elements to be removed.
     * @return true if any elements were removed,
     *         false if no elements were removed.
     */
    public boolean removeAll(T[] elems) {
        boolean removed = false;
        for (T element : elems) {
            if (remove(element)) {
                removed = true;
            }
        }
        return removed;
    }

    /**
     * Checks to see if the collection contains a given element.
     *
     * @param elem The element we are checking for.
     * @return true if the collection contains elem, false otherwise.
     */
    public boolean contains(T elem) {
        return indexOf(elem) >= 0;
    }

    /**
     * Gets an element from the collection, using its 0-based index.
     * If the index is within the backing array but more than the last
     * element, the method throws a java.util.NoSuchElementException.
     *
     * @param index The index of the element we want.
     * @return The element at the specified index.
     */
    public T get(int index) {
        if (index >= elementCount) {
            throw new NoSuchElementException();
        }
        return genericArray[index];
    }

    /**
     * Returns the current number of elements in the collection.
     *
     * @return The size of the collection.
     */
    public int size() {
        return elementCount;
    }

    /**
     * Returns the current capacity of the collection - namely, the
     * size of its backing array.
     *
     * @return The total capacity of the collection.
     */
    public int capacity() {
        return size;
    }

    /**
     * Clears the collection, resetting size and starting from a fresh
     * backing array of size 5.
     */
    public void clear() {
        size = 5;
        elementCount = 0;
        genericArray = (T[]) new Object[size];
    }

    /**
     * Tests if the collection is empty.
     *
     * @return true if the collection has no elements, false otherwise.
     */
    public boolean isEmpty() {
        return elementCount == 0;
    }

    /**
     * Returns a String representation of the collection
     * in the form of:
     * [element1, element2, element3, ..., elementN]
     * @return [element1, element2, element3, ..., elementN]
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < elementCount; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(genericArray[i]);
        }
        sb.append(']');
        return sb.toString();

    }

    /**
     * Finds the index of the first instance of
     * elem in the backing array.
     * @param  elem The element that the method is checking for.
     * @return The index of the specified element if
     *         the element is in the array and -1 if
     *         the element is not in the array.
     */
    private int indexOf(T elem) {
        if (elem == null) {
            for (int i = 0; i < size; i++) {
                if (genericArray[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elem.equals(genericArray[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
}