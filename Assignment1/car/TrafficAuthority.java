public class TrafficAuthority {
    private String name;
    private String jurisdiction;

    public TrafficAuthority(String name, String jurisdiction) {
        this.name = name;
        this.jurisdiction = jurisdiction;
    }

    public String getName() {
        return name;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void registerCar(Car car, CarOwner owner) {
        car.setRegistered(true);
        car.setOwner(owner);
    }

    public void deregisterCar(Car car) {
        car.setRegistered(false);
        car.setOwner(null);
    }
}
