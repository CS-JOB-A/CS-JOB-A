package java_240822.ex02;

public class HomeAgency implements Rentable<Home> { // 타입 파라미터 Home으로 대체
    @Override
    public Home rent() {
        return new Home();
    }
}
