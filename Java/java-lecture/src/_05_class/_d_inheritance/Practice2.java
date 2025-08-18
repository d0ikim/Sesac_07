package _05_class._d_inheritance;

public class Practice2 {
    public static void main(String[] args) {
        System.out.println("=== bus 정보 ===");
        Bus bus = new Bus("Hyundai", "City Bus", 2022, 30);
        bus.start();
        bus.transport();
        bus.stop();

        System.out.println("\n=== Car 정보 ===");
        Car car = new Car("Toyota", "Camry", 2023, true);
        car.start();
        car.parking();
        car.stop();

        System.out.println("\n=== Motorcycle 정보 ===");
        Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Sportster", 2021, "A");
        motorcycle.start();
        motorcycle.vroom();
        motorcycle.stop();
    }
}

class Vehicles {
    String brand;
    String model;
    int year;

    public Vehicles(String b, String m, int y){
        this.brand = b;
        this.model = m;
        this.year = y;
    }

    void start(){
        System.out.println("차량 시동을 걸었습니다.");
    }
    void parking(){
        System.out.println("주차했습니다.");
    }
    void stop(){
        System.out.println("차량을 정지했습니다.");
    }
}

class Bus extends Vehicles{
    int passengerCapacity;

    public Bus(String brand, String model, int year, int passengerCapacity){
        super(brand, model, year);
        this.passengerCapacity = passengerCapacity;
        System.out.printf("Bus {brand=%s, model=%s, year=%d, passengerCapacity=%d}\n", this.brand, this.model, this.year, this.passengerCapacity);
    }

    void transport(){
        System.out.println("승객을 운송합니다.");
    }
}

class Car extends Vehicles{
    boolean isConvertible;

    public Car(String brand, String model, int year, boolean isConvertible){
        super(brand, model, year);
        this.isConvertible = isConvertible;
        System.out.printf("Car {brand=%s, model=%s, year=%d, convertible=%s}\n", this.brand, this.model, this.year, this.isConvertible);
    }
}

class Motorcycle extends Vehicles{
    String licenseType;

    public Motorcycle(String brand, String model, int year, String licenseType){
        super(brand, model, year);
        this.licenseType = licenseType;
        System.out.printf("Motorcycle {brand=%s, model=%s, year=%d, licenseType='%s'}\n", this.brand, this.model, this.year, this.licenseType);
    }

    void vroom(){
        System.out.println("울림통을 울립니다.");
    }
}