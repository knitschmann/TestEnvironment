/**
 * Created by kevin on 22/10/15.
 */
public class DoublyDataObject<T> {
    private DoublyDataObject prev;
    private DoublyDataObject next;
    private T data;

    public DoublyDataObject(DoublyDataObject prev, DoublyDataObject next, T data) {
        this.prev = prev;
        this.next = next;
        this.data = data;
    }

    public DoublyDataObject(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoublyDataObject getPrev() {
        return prev;
    }

    public void setPrev(DoublyDataObject prev) {
        this.prev = prev;
    }

    public DoublyDataObject getNext() {
        return next;
    }

    public void setNext(DoublyDataObject next) {
        this.next = next;
    }
}
