package java_240621;

public class Singleton {
    // private 접근 권한을 갖는 정적 필드 선언과 초기화 - 외부에서 정적 필드값 변경하지 못하도록 함
    private static Singleton singleton = new Singleton();

    // private 접근 권환을 갖는 생성자 선언
    private Singleton(){

    }

    // public 접근 권한을 갖는 정적 메소드 선언 - 정적 필드값을 리턴
    public static Singleton getSingleton() {
        return singleton;
    }
}
