package java_2407.java_240725;

public class A2 {
    // 인스턴스 멤버 클래스
    class B2 {
        // 인스턴스 필드
        int field1 = 1;

        // 정적 필드 - JAVA 17부터 허용
        static int field2 = 2;

        // 생성자
        B2() {
            System.out.println("B2 생성자 실행");
        }

        // 인스턴스 메소드
        void method1() {
            System.out.println("B2 method2 실행");
        }

        // 정적 메소드 - JAVA 17부터 허요
        static void method2() {
            System.out.println("B2 method2 실행");
        }
    }
    // 인스턴스 메소드
    void useB() {
        // B 객체 생성 및 인스턴스 필드 및 메소드 사영
        B2 b2 = new B2();
        System.out.println(b2.field1);
        b2.method1();

        // B 클래스의 정적 필드 및 메소드 사용
        System.out.println(B2.field2);
        B2.method2();
    }
}
