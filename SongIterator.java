package prj5;

import java.util.Iterator;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- natjac99

/**
 * This is the Song Iterator class
 * 
 * @author Natalia Jacobo (natjac99)
 * @version 04.15.2019
 */
public SongIterator<D> iterator(){
    return new LList<T>();}

private class LList<T> implements SongIterator<D> {
    private Node<D> current;
    private boolean call;


    public SongIterator() {
            current = head;
            call = false;
        }


    public boolean hasNext() {
        return (current.next.getData() != null);
    }


    public D next() {
        if (this.hasNext()) {
            call = true;
            current = current.next;
            return current.getData();
        }
        else {
            throw new NoSuchElementException("No songs up next");
        }
    }


public void remove() {
    if (!call) {
        throw new IllegalStateException("Remove is not valid");
    }
    current.previous.setNext(current.next);
    current.next.setPrevious(current.previous);
    current = current.previous;
    call = false;
    size--;
}
}