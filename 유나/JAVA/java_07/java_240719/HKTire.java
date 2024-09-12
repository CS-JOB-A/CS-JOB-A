package java_07.java_240719;

public class HKTire implements Tire{
    // 추상 메소드 재정의
    @Override
    public void roll(){
        System.out.println("한국 타이어가 굴러갑니다.");
    }
}
