public class Manufacturer {
    private String name;
    private String country;

    public Manufacturer(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Car produceCar(String model, String color, int year) {
        return new Car(this, model, color, year);
    }
}
