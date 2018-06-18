package XmlParser.api;

public class Employee{
    String id;
    String firstName;
    String lastName;
    String location;

    @Override
    public String toString() {
        return firstName+" "+lastName+"("+id+")"+location;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}