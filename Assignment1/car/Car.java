public class Car {
    private Manufacturer manufacturer;
    private String model;
    private String color;
    private int year;
    private boolean isRegistered;
    private CarOwner owner;

    public Car(Manufacturer manufacturer, String model, String color, int year) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.color = color;
        this.year = year;
        this.isRegistered = false;
        this.owner = null;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public CarOwner getOwner() {
        return owner;
    }

    public void setOwner(CarOwner owner) {
        this.owner = owner;
    }
}
