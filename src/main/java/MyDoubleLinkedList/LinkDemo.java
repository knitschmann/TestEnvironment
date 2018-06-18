package MyDoubleLinkedList;

/**
 * Created by kevin on 22/10/15.
 */
public class LinkDemo {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> myList = new DoublyLinkedList<>();

        System.out.println(myList.isEmpty());

        myList.addFirst(2);
        System.out.println(myList.isEmpty());
        myList.displayList();

        myList.addFirst(1);
        myList.displayList();

        myList.addLast(3);
        myList.displayList();

        myList.removeLast();
        myList.displayList();

        myList.removeFirst();
        myList.displayList();
    }
}
