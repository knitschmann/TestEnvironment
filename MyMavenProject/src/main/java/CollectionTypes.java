import java.util.Stack;

/**
 * Created by kevin on 12/09/15.
 */
public class CollectionTypes {

    static Stack myStapel = new Stack();
    static Queue

    public static void main(String args[]){
        CollectionTypes col = new CollectionTypes();
        col.runIt();
    }
    public CollectionTypes() {
    }

    void runIt(){
        myStapel.push(5);
        myStapel.peek();
        myStapel.pop();

    }
}
