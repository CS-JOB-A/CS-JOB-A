package java_2406.java_240621;

public class SingletoneExample {
    public static void main(String[] args) {
//        Singleton obj1 =  new Singleton(); == 컴파일 에러

        // 정적 메소드 호출해서 싱글톤 객체 얻음
        Singleton obj1 = Singleton.getSingleton();

    }
}
