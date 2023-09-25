import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 创建厂家
        Manufacturer manufacturer = new Manufacturer("Example", "Country A");

        // 创建车主
        CarOwner owner1 = new CarOwner("Bob", 1001);
        CarOwner owner2 = new CarOwner("Jane", 1002);

        // 交互式控制台界面
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Produce Car");
            System.out.println("2. Buy Car");
            System.out.println("3. Sell Car");
            System.out.println("4. Register Car");
            System.out.println("5. Deregister Car");
            System.out.println("6. Quit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符

            switch (choice) {
                case 1:
                    System.out.print("Enter car model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter car color: ");
                    String color = scanner.nextLine();
                    System.out.print("Enter car year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // 消耗换行符

                    Car newCar = manufacturer.produceCar(model, color, year);
                    System.out.println("New car produced: " + newCar.getModel());
                    break;

                case 2:
                    System.out.print("Enter owner name: ");
                    String ownerName = scanner.nextLine();
                    CarOwner currentOwner = (ownerName.equals("John Doe")) ? owner1 : owner2;

                    System.out.print("Enter car model to buy: ");
                    String carModel = scanner.nextLine();
                    Car currentCar = manufacturer.produceCar(carModel, "Default Color", 2023);

                    currentOwner.buyCar(currentCar);
                    System.out.println(currentOwner.getName() + " bought " + currentCar.getModel());
                    break;

                case 3:
                    System.out.print("Enter owner name: ");
                    ownerName = scanner.nextLine();
                    currentOwner = (ownerName.equals("John Doe")) ? owner1 : owner2;

                    currentOwner.sellCar();
                    System.out.println(currentOwner.getName() + " sold their car");
                    break;

                case 4:
                    System.out.print("Enter owner name: ");
                    ownerName = scanner.nextLine();
                    currentOwner = (ownerName.equals("John Doe")) ? owner1 : owner2;

                    System.out.print("Enter car model to register: ");
                    carModel = scanner.nextLine();
                    currentCar = manufacturer.produceCar(carModel, "Default Color", 2023);

                    TrafficAuthority trafficAuthority = new TrafficAuthority("Traffic Authority", "Region A");
                    trafficAuthority.registerCar(currentCar, currentOwner);
                    System.out.println(currentOwner.getName() + "'s car registered");
                    break;

                case 5:
                    System.out.print("Enter car model to deregister: ");
                    carModel = scanner.nextLine();
                    currentCar = manufacturer.produceCar(carModel, "Default Color", 2023);

                    trafficAuthority = new TrafficAuthority("Traffic Authority", "Region A");
                    trafficAuthority.deregisterCar(currentCar);
                    System.out.println(currentCar.getModel() + " deregistered");
                    break;

                case 6:
                    System.out.println("Exiting program");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
