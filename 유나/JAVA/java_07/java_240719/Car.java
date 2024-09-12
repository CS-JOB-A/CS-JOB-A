package java_07.java_240719;

public class Car {
    // 필드
    Tire tire1 =  new HKTire();
    Tire tire2 = new HKTire();

    // 메소드
    void run(){
        // 인터페이스에 선언된 추상메소드 호출
        tire1.roll();
        tire2.roll();
    }
}
