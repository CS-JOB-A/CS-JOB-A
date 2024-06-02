package day02;

public class day03_enum {
    public static void main(String[] args) {
        // 열거 타입 변수 선언
        Week today = null;
        today = Week.SUNDAY;


        // 열거값 비교
        if (today == Week.SUNDAY) {
            System.out.println("눈 감기전까지는 일요일이야");
        } else {
            System.out.println("즐거우실까요?");
        }
    }
}
