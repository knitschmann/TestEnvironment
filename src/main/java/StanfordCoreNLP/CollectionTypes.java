package StanfordCoreNLP;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;

/**
 * Created by kevin on 12/09/15.
 */
public class CollectionTypes {

    static Stack myStapel = new Stack();

    public static void main(String args[]){
        CollectionTypes col = new CollectionTypes();
//        col.runIt();
        col.hashDifferences();
    }
    public CollectionTypes() {
    }

    void runIt(){
        myStapel.push(5);
        myStapel.peek();
        myStapel.pop();

    }

    void hashDifferences(){
        Hashtable<String,String> hashtableobj = new Hashtable<String, String>();
        hashtableobj.put("Alive is ", "awesome");
        hashtableobj.put("Love", "yourself");
        System.out.println("Hashtable object output :"+ hashtableobj);



        HashMap hashmapobj = new HashMap();
        hashmapobj.put("Alive is ", "awesome");
        hashmapobj.put("Love", "yourself");
        System.out.println("HashMap object output :"+hashmapobj);
    }
}
