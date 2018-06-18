package StanfordCoreNLP;

/**
 * Created by kevin on 03/08/15.
 */
public class OuterClass {

    private int outerInt;
//    static int outerStatic = 5;
    public OuterClass(int outerInt){
        this.outerInt = outerInt;
    }

    public int getOuterInt() {
        return outerInt;
    }

    public void setOuterInt(int outerInt) {
        this.outerInt = outerInt;
    }

//    public static int getOuterStatic() {
//        return outerStatic;
//    }
//
//    public static void setOuterStatic(int outerStatic) {
//        OuterClass.outerStatic = outerStatic;
//    }
    class InnerClass{
        int innerInt;

        public InnerClass(int innerInt){
            this.innerInt = innerInt;
        }

        public int getInnerInt() {
            return innerInt;
        }

        public void setInnerInt(int innerInt) {
            this.innerInt = innerInt;
        }

    public void foo(){
        System.out.println(outerInt);
    }
    }

//    static class InnerStatic{
//        int staticInnerInt;
//
//        public InnerStatic(int a){
//            staticInnerInt = a;
//        }
//
//        public int getStaticInnerInt() {
//            return staticInnerInt;
//        }
//
//        public void setStaticInnerInt(int staticInnerInt) {
//            this.staticInnerInt = staticInnerInt;
//        }
//    }
}


