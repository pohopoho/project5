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
 * 
 * 
 * @author Punita Verma (punitav9)
 * @version 04.14.2019
 *
 */
public class LList<T> implements ListInterface<T>, Iterable<T>{

    private Node head;
    private Node tail;
    private int numberOfEntries;


    public LList() {
        head = null;
        tail = null;
        numberOfEntries = 0;

    }


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


    @Override
    public void clear() {
        head = null;
        tail = null;
        numberOfEntries = 0;
    }


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


    @Override
    public int getLength() {
        return numberOfEntries;
    }


    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


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
                if (toRemove != tail){
                    Node after = toRemove.getNext();
                    before.setNext(after);
                }  
                result = toRemove.getData();
                /*if (position == numberOfEntries) {
                    tail = before;
                }*/
            }  
            numberOfEntries--; 
            return result;
        }
        else {
            throw new IndexOutOfBoundsException();
        }

    }


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


    public int size() {
        return numberOfEntries;
    }


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


    private class Node {
        private T data;
        private Node nextNode;


        public Node(T t) {
            data = t;
        }


        public void setNext(Node next) {
            nextNode = next;
        }


        public T getData() {
            return data;
        }


        public void setData(T anEntry) {
            data = anEntry;
        }


        public Node getNext() {
            return nextNode;
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new LListIterator();
    }


    private class LListIterator implements Iterator<T> {

        private Node curr;


        public LListIterator() {
            curr = new Node(null);
            curr.setNext(head);
        }
 

        @Override
        public boolean hasNext() {
            return (curr.nextNode != null);
        }


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
