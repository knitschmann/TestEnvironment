package MD5;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD {
    public static void main(String args[]) throws Exception {
        String s = "https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2FSamsungDeutschland%2Fposts%2F2013238358746884%3A0&width=500";
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(s.getBytes(), 0, s.length());
        System.out.println("MD5: " + new BigInteger(1, m.digest()).toString(16));
    }
}
