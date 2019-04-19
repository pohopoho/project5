/**
 * Virginia Tech Honor Code Pledge:
 *
 * As a Hokie, I will conduct myself with honor
 * and integrity at all times.
 * I will not lie, cheat, or steal, nor will I
 * accept the actions of those who do.
 * -- Daniel Moreno (danielrm)
 */
package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import list.ListInterface;

/**
 * Creates the LList class
 * 
 * @author Punita Verma (punitav9)
 * @version 04.14.2019
 * @param <T>
 *            the type for this class
 */
public class LList<T> implements ListInterface<T>, Iterable<T> {

    private Node head;
    private Node tail;
    private int numberOfEntries;


    /**
     * Constructor
     */
    public LList() {
        head = null;
        tail = null;
        numberOfEntries = 0;

    }


    /**
     * adds an entry to the list
     * 
     * @param anEntry
     *            the entry to be added
     */
    @Override
    public void add(T anEntry) {
        Node newNode = new Node(anEntry);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.setNext(newNode);
            tail = newNode;

        }
        numberOfEntries++;
    }


    /**
     * adds and entry to the list at a specified position,
     * if position is illegal, throws an IndexOutOfBoundsException
     * 
     * @param position
     *            the position to be added at
     * @param anEntry
     *            the entry to be added
     */
    @Override
    public void add(int position, T anEntry) {
        if ((position >= 1) && (position <= numberOfEntries + 1)) {
            Node newNode = new Node(anEntry);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            }
            else if (position == 1) {
                newNode.setNext(head);
                head = newNode;
            }
            else if (position == numberOfEntries) {
                tail.setNext(newNode);
                tail = newNode;
            }
            else {
                Node before = getNodeAt(position - 1);
                Node after = before.getNext();
                newNode.setNext(after);
                before.setNext(newNode);
            }
            numberOfEntries++;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }


    /**
     * clears the list
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        numberOfEntries = 0;
    }


    /**
     * checks if the list contains a given entry
     * 
     * @param anEntry
     *            the entry to be added
     * @return true if entry is in the list, false if not
     */
    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node current = head;
        while (!found && (current != null)) {
            if (current.data.equals(anEntry)) {
                found = true;
            }
            else {
                current = current.getNext();
            }

        }
        return found;
    }


    /**
     * retrieves an entry at a given position
     * 
     * @param position
     *            the position whose entry is to be returned
     * @return the entry at the given position, if not found, throws a
     *         IndexOutOfBoundsException
     */
    @Override
    public T getEntry(int position) {
        if ((position >= 1) && (position <= numberOfEntries)) {
            assert !isEmpty();
            return getNodeAt(position).getData();
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }


    /**
     * accessor for list length(numberOfEntries)
     * 
     * @return the length(numberOfEntries) of the list
     */
    @Override
    public int getLength() {
        return numberOfEntries;
    }


    /**
     * checks if the list is empty
     * 
     * @return true if empty, false if not empty
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


    /**
     * removes an entry in the list at a given position
     * 
     * @param position
     *            the position whose entry to be removed
     * @return the removed entry, if position is illegal, throws
     *         IndexOutOfBoundsException
     */
    @Override
    public T remove(int position) {
        T result = null;
        if ((position >= 1) && (position <= numberOfEntries)) {
            assert !isEmpty();
            if (position == 1) {
                result = head.getData();
                head = head.getNext();
                if (numberOfEntries == 1) {
                    tail = null;
                }
            }
            else {
                Node before = getNodeAt(position - 1);
                Node toRemove = before.getNext();
                Node after = toRemove.getNext();
                result = toRemove.getData();
                before.setNext(after);
                if (position == numberOfEntries) {
                    tail = before;
                }
            }
            numberOfEntries--;
            return result;
        }
        else {
            throw new IndexOutOfBoundsException();
        }

    }


    /**
     * replaces the data in the node at a given position
     * with a new given data (entry)
     * 
     * @param position
     *            the position at which to replace node's data
     * @param anEntry
     *            the data to replace with
     * @return the replaced data, if position is illegal, throws
     *         IndexOutOfBoundsException
     */
    @Override
    public T replace(int position, T anEntry) {
        if ((position >= 1) && (position <= numberOfEntries)) {
            assert !isEmpty();
            Node desiredNode = getNodeAt(position);
            T originalEntry = desiredNode.getData();
            desiredNode.setData(anEntry);
            return originalEntry;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }


    /**
     * creates and returns an array representation of the list
     * 
     * @return the array representation of the list
     */
    @Override
    public Object[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        int index = 0;
        Node current = head;
        while ((index < numberOfEntries) && current != null) {
            result[index] = current.getData();
            current = current.getNext();
            index++;
        }
        return result;
    }


    /**
     * helper method to retrieve a node at a given position
     * 
     * @param index
     *            the index to find a node at
     * @return the node at the given index
     */
    private Node getNodeAt(int index) {
        assert (head != null) && (1 <= index) && (index <= numberOfEntries);

        Node curr = head;
        int counter = 1;
        while (counter != index && curr.getNext() != null) {
            curr = curr.getNext();
            counter++;
        }
        return curr;
    }


    /**
     * compares this object with another object
     * 
     * @param obj
     *            the object to be compared to
     * @return true if equal, false if not equal
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            LList<T> other = ((LList<T>)obj);
            if (other.getLength() == this.getLength()) {
                Node otherCurrent = other.head;
                Node current = head;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.getNext();
                    otherCurrent = otherCurrent.getNext();
                }
                return true;
            }
        }

        return false;
    }


    /**
     * Inner node class
     * 
     * @author Michael Cheung
     *
     */
    private class Node {
        private T data;
        private Node nextNode;


        /**
         * Constructor for Node
         * 
         * @param t
         *            the object t
         */
        public Node(T t) {
            data = t;
        }


        /**
         * Sets the next node
         * 
         * @param next
         *            the next node
         */
        public void setNext(Node next) {
            nextNode = next;
        }


        /**
         * Gets the data
         * 
         * @return the data
         */
        public T getData() {
            return data;
        }


        /**
         * Sets the data for the entry
         * 
         * @param anEntry
         *            the data being used for the set
         */
        public void setData(T anEntry) {
            data = anEntry;
        }


        /**
         * Gets the next node
         * 
         * @return the next node
         */
        public Node getNext() {
            return nextNode;
        }
    }


    /**
     * creates an Iterator for this list
     * 
     * @return a new Iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new LListIterator();
    }


    /**
     * Iterator inner class
     * 
     * @author Michael Cheung
     *
     */
    private class LListIterator implements Iterator<T> {

        private Node curr;


        /**
         * Constructor for the LListIterator
         */
        public LListIterator() {
            curr = new Node(null);
            curr.setNext(head);
        }


        /**
         * Checks whether the next node is null or not
         * 
         * @return true if not null, false otherwise
         */
        @Override
        public boolean hasNext() {
            return (curr.nextNode != null);
        }


        /**
         * Finds the data of the next element
         * 
         * @return the data t
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T temp = curr.getData();
            curr = curr.getNext();
            return temp;
        }

    }

}
