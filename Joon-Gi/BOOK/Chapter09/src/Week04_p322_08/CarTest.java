package Week04_p322_08;

public class CarTest {
    public static void main(String[] args) {
        System.out.println("=== 자율주행하는 자동차 ===");
        Car myCar = new AICar();
        myCar.run();

        System.out.println("=== 사람이 운전하는 자동차 ===");
        Car hisCar = new ManualCar();
        hisCar.run();
    }
}
