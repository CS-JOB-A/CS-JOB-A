package java_240822.ex02;

public class CarAgency implements Rentable<Car>{
    @Override
    public Car rent() {
        return new Car(); // 리턴 타입 반드시 Car여야 함
    }
}
