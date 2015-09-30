/**
 * Created by kevin on 30/09/15.
 */
public class Person {
    private int id;
    private String name;
    private int taxId;
    private Address address;

    public Person(){}
    public Person(int id, String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTaxId() {
        return taxId;
    }

    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taxId=" + taxId +
                ", address=" + address +
                '}';
    }

    /**
     * every spring bean also has a onCreate and onDestroy method
     * to be set in the beans.xml as init-method="" and destroy-method=""
     */
    public void onCreate(){
        System.out.println("Person created");
    }
    public void onDestroy(){
        System.out.println("Person destroyed");
    }
}
