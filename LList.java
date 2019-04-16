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
public class LList<T> implements ListInterface<T> {

    private Node<T> head;
    private Node<T> tail;
    // private Node lastNode;
    private int size;
    private Node<T> current;


    public LList() {
        head = new Node<T>(null);
        tail = new Node<T>(null);
        current = head;
        size = 0;
    }


    @Override
    public void add(T anEntry) {
        if (anEntry != null) {
            add(size(), anEntry);
        }
        else {
            throw new IllegalArgumentException(
                "Entry passed is Illegal:/ Please try again!");
        }
    }


    @Override
    public void add(int position, T anEntry) {
        if (anEntry == null) {
            throw new IllegalArgumentException(
                "Entry passed is Illegal:/ Please try again!");
        }
        if (position >= 0 && position <= size) {
            Node<T> newEntry = new Node<T>(anEntry);
            if (position == 0) {
                head.setNext(newEntry);
            }
            else {
                for (int i = 0; i < position; i++) {
                    current = current.nextNode;
                }
                current.setNext(newEntry);
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
        if (head != null) {
            head.nextNode = null;
            head = null;
        }
        size = 0;
    }


    @Override
    public boolean contains(T anEntry) {
        if (anEntry == null || isEmpty()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (current.data.equals(anEntry)) {
                return true;
            }
            current = current.nextNode;
        }
        return false;
    }


    @Override
    public T getEntry(int position) {
        if (position == 0) {
            return current.getData();
        }
        else if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException(
                "Position entered is invalid:/ Please try again!");
        }
        else {
            for (int i = 0; i <= position; i++) {
                current = current.next();
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
        if (index) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (current.nextNode.getData().equals(anEntry)) {
                current.setNext(current.nextNode.nextNode);
                return true;
            }
            current = current.nextNode;
        }
        return false;
    }


    public boolean remove(T anEntry) {
        if (anEntry == null || isEmpty()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (current.nextNode.getData().equals(anEntry)) {
                current.setNext(current.nextNode.nextNode);
                return true;
            }
            current = current.nextNode;
        }
        return false;
    }


    @Override
    public T replace(int index, T anEntry) {

    }


    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
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
                Node<T> otherCurrent = other.head;
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


    private class Node<D> {
        private D data;
        private Node<D> nextNode;


        public Node(D d) {
            data = d;
        }


        public void setNext(Node<D> next) {
            nextNode = next;
        }


        public D getData() {
            return data;
        }

    }

}
