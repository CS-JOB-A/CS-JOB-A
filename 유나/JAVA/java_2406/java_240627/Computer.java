package java_2406.java_240627;

public class Computer extends Calculator{
    // 메소드 오버라이딩
    @Override // 컴파일시 저오학히 오버라이딩이 되었는지 체크 (생략가능)
    public double areaCircle(double r){
        System.out.println("Computer 객체의 areaCircle 실행");
        return Math.PI * r * r;
    }
}
