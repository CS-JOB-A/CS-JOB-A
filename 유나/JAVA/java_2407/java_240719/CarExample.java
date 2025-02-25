package java_2407.java_240719;

public class CarExample {
    public static void main(String[] args) {
        // 자동화 객체 생성
        Car myCar = new Car();

        // run() 메소드 실행
        myCar.run();

        // 타이터 객체 교체
        myCar.tire1 = new KHTire();
        myCar.tire2 = new KHTire();

        // run() 메소드 실행(다형성: 실행 결과가 다름)
        myCar.run();
    }
}
