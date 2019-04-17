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
public class LList<T> implements ListInterface<T>, Iterable<T> {

    private Node head;
    private Node tail;
    private int size;
    private Node current;


    public LList() {
        head = new Node(null);
        tail = new Node(null);
        size = 0;
        head.setNext(tail);
    }


    @Override
    public void add(T anEntry) {
        add(size+1, anEntry);
    }


    @Override
    public void add(int position, T anEntry) {
        if ((position >= 0) && (position <= size + 1)) {
            Node newEntry = new Node(anEntry);
            if (position == 1) {
                head.setNext(newEntry);
            }
            else {
                current = head;
                for (int i = 1; i < position; i++) {
                    current = current.nextNode;
                }
                Node nodeBefore = current;
                Node nodeAfter = current.nextNode;
                nodeBefore.setNext(newEntry);
                newEntry.setNext(nodeAfter);
            }
            size++;
        }
        else {
            throw new IndexOutOfBoundsException(
                "Position for new entry is invalid:/ Please try again!");
        }
    }


    @Override
    public void clear() {
        head.nextNode = null;
        size = 0;
    }


    @Override
    public boolean contains(T anEntry) {
        if (anEntry == null || isEmpty()) {
            return false;
        }
        current = head.nextNode;
        while (current != null) {
            if (current.data.equals(anEntry)) {
                return true;
            }
            current = current.nextNode;
        }
        return false;
    }


    @Override
    public T getEntry(int position) {
        current = head.nextNode;
        if (position == 0) {
            return current.getData();
        }
        else if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException(
                "Position entered is invalid:/ Please try again!");
        }
        else {  
            for (int i = 0; i < position; i++) {
                current = current.nextNode;
            }
            return current.getData();
        }
    }


    @Override
    public int getLength() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "Illegal index value! Please enter a valid index value.");
        }
        current = head.nextNode;
        /*if (index == 0) {
            return current.nextNode.getData();
        }*/
        for (int i = 0; i < index; i++) {
            current = current.nextNode;
        }
        Node result = current.nextNode;
        current.nextNode = current.nextNode.nextNode;
        size--;
        return result.getData(); 
    }


    public boolean remove(T anEntry) {
        if (anEntry == null || isEmpty()) {
            return false;
        }
        current = head.nextNode;
        if (contains(anEntry)) {
            while (current != null) {
                if (current.getData().equals(anEntry)) {
                    current.setNext(current.nextNode.nextNode);
                    return true;
                }
                current = current.nextNode;
            }
        }
        return false;
    }


    @Override
    public T replace(int index, T anEntry) {
        if (anEntry == null || index < 0 || index > size) {
            throw new IllegalArgumentException(
                "Invalid argument! Please pass a valid argument.");
        }
        current = head;
        if (index == 0) {
            return head.nextNode.getData();
        }
        int counter = 0;
        while (counter != index) { 
            current = current.nextNode; 
            counter++;
        }
        T result = current.getData();
        current.nextNode.setData(anEntry);
        return result; 
    }
 
 
    @Override
    public Object[] toArray() {
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty");
        }
        Object[] arr = new Object[size];
        for (int i = 0; i < size; i++) {
            arr[i] = getEntry(i);
        }
        return arr;
    }


    public int size() {
        return size; 
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
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.nextNode;
                    otherCurrent = otherCurrent.nextNode;
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
    }

}
