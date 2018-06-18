package MyDoubleLinkedList;

/**
 * Created by kevin on 22/10/15.
 */
public class DoublyLinkedList<T> {

    DoublyDataObject<T> head;
    DoublyDataObject<T> tail;
    int size = 0;

    public void addFirst(T data) {
        DoublyDataObject current = new DoublyDataObject(data);
        if (isEmpty()) {
            head = current;
            tail = current;
            size++;
        } else {
            head.setPrev(current);
            current.setNext(head);
            head = current;
            size++;
        }
    }

    public void addLast(T data) {
        DoublyDataObject current = new DoublyDataObject(data);
        if (isEmpty()) {
            tail = current;
            head = current;
            size++;
        } else {
            tail.setNext(current);
            current.setPrev(tail);
            tail = current;
            size++;
        }
    }

    public void removeFirst() {
        if (head == null) {
            return;
        } else {
            head = head.getNext();
            head.setPrev(null);
            size--;
        }
    }

    public void removeLast() {
        if (tail == null) {
            return;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
            size--;
        }
    }

    public void displayList() {
        DoublyDataObject current = head;
        while (current != null) {
            System.out.print(current.getData() + ", ");
            current = current.getNext();
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return (size == 0);
    }
}
