public class CarOwner {
    private String name;
    private int id;
    private Car car;

    public CarOwner(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void buyCar(Car car) {
        this.car = car;
        car.setOwner(this);
    }

    public void sellCar() {
        if (car != null) {
            car.setOwner(null);
            car = null;
        }
    }
}
