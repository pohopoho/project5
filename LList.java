// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- punitav9
/**
 * 
 */
package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
// import org.w3c.dom.Node;
// import linkedlist.SinglyLinkedList;
// import linkedlist.SinglyLinkedList.Node;
import list.ListInterface;

/**
 * @param<T> this
 *               is the T parameter for ListInterface and Iterable
 * 
 * @author Punita Verma (punitav9)
 * @version 04.14.2019
 *          This is the LList class.
 */
public class LList<T> implements ListInterface<T>, Iterable<T> {

    private Node head;
    private Node tail;
    private int numberOfEntries;


    public LList() {
        head = null;
        tail = null;
        numberOfEntries = 0;

    }

/**
 * This is the add(T anEntry) method. 
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

            Node curr = head;
            for (int i = 1; i < size(); i++) {
                curr = curr.nextNode;
            }
            curr.setNext(newNode);
        }
        numberOfEntries++;
    }

/**
 * This is the add(int position, T anEntry) method.
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
                Node before = getNodeAt(position - 1);
                Node temp = tail;
                tail = newNode;
                tail.setNext(temp);
                tail = temp;
                before.setNext(newNode);
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
     * This is the clear() method.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        numberOfEntries = 0;
    }


    /**
     * This is the contains(T anEntry) method.
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
     * This is the getEntry method. It gets an entry from list.
     */
    @Override
    public T getEntry(int position) {
        if ((position >= 1) && (position <= numberOfEntries)) {
            return getNodeAt(position).getData();
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }


    /**
     * This is the getLength() method. It returns the
     * number of entries from list.
     */
    @Override
    public int getLength() {
        return numberOfEntries;
    }


    /**
     * This is the isEmpty() method. It returns number of entries == 0.
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


    /**
     * This is the remove(int position). It removes an int at a given
     * position.
     */
    @Override
    public T remove(int position) {
        T result = null;
        if ((position >= 1) && (position <= numberOfEntries)) {
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
                if (toRemove != tail) {
                    Node after = toRemove.getNext();
                    before.setNext(after);
                }
                result = toRemove.getData();

            }
            numberOfEntries--;
            return result;
        }
        else {
            throw new IndexOutOfBoundsException();
        }

    }


    /**
     * This is the replace(int position, T anEntry). This removes a
     * specific entry from a position.
     */
    @Override
    public T replace(int position, T anEntry) {
        if ((position >= 1) && (position <= numberOfEntries)) {
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
     * This is the toArray() method.
     */
    @Override
    public Object[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        int index = 0;
        Node current = head;
        while (current != null) {
            result[index] = current.getData();
            current = current.getNext();
            index++;
        }
        return result;
    }


    /**
     * This is the size() method.
     * 
     * @return numberOfEntries returns numberOfEntries
     */
    public int size() {
        return numberOfEntries;
    }


    /**
     * This is the the getNodeAt(int index)
     * 
     * @param index
     *            this is the parameter for index
     * @return curr this returns current node
     */
    private Node getNodeAt(int index) {
        Node curr = head;
        int counter = 1;
        while (counter != index) {
            curr = curr.getNext();
            counter++;
        }
        return curr;
    }


    /**
     * This is the equals(Object obj) method. This compares elements in
     * the list to determine if they are equal.
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
            if (other.size() == this.size()) {
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
     * This is the private Node class.
     * 
     * @author Natalia Jacobo
     * @version 4.20.2019
     *
     */
    private class Node {
        private T data;
        private Node nextNode;


        /**
         * This Node(T t) is the constructor.
         * 
         * @param t
         *            this is the parameter t.
         */
        public Node(T t) {
            data = t;
        }


        /**
         * This is the setNext(Node next) method.
         * 
         * @param next
         *            this is the parameter for next
         */
        public void setNext(Node next) {
            nextNode = next;
        }


        /**
         * This is the getData() method.
         * 
         * @return data returns data
         */
        public T getData() {
            return data;
        }


        /**
         * This is the setData(T anEntry).
         * 
         * @param anEntry
         *            this is the anEntry parameter
         */
        public void setData(T anEntry) {
            data = anEntry;
        }


        /**
         * This is the getNext() method.
         * 
         * @return nextNode returns nextNode
         */
        public Node getNext() {
            return nextNode;
        }
    }


    /**
     * This is the iterator() constructor.
     */
    @Override
    public Iterator<T> iterator() {
        return new LListIterator();
    }


    /**
     * This is the LListIterator private class.
     * 
     * @author Natalia Jacobo (natjac99)
     * @version 4.20.2019
     */
    private class LListIterator implements Iterator<T> {

        private Node curr;

/**
 * This is the LListIterator() constructor.
 */
        public LListIterator() {
            curr = new Node(null);
            curr.setNext(head);

        }

/**
 * This is the hasNext() method.
 */
        @Override
        public boolean hasNext() {
            return (curr.nextNode != null);
        }

/**
 * This is the next() method.
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
