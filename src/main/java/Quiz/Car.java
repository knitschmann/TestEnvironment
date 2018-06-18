package Quiz;


public class Car extends Vehicle {
    int id = 100;

    public int getId() {
        return (id - 20);
    }

    public static void main(String[] args) {
        Vehicle vc = new Car();
//        Car car = (Car) vc;
        System.out.print(vc.id + ", " + vc.getId() + ", ");
        System.out.println(vc);
//        System.out.print(car.id + ", " + car.getId());
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", id=" + id +
                '}';
    }
}
