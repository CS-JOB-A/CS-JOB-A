# 9.3 정적 멤버 클래스
- static 키워드와 함께 A 클래스의 멤버로 선언된 B 클래스

```java
public class A {
    public static class B{ // 정적 멤버 클래스
    }
}
```

- 접근 제한자에 따른 정적 멤버 클래스의 접근 범위

| 구분                        | 접근 범위                        |
|:--------------------------|:-----------------------------|
| public static class B {}  | 다른 패키지에서 B 클래스를 사용할 수 있다.    |
| static class B {}         | 같은 패키지에서만 B 클래스를 사용할 수 있다.   |
| private static class B {} | A 클래스 내부에서만 B 클래스를 사용할 수 있다. |

- A 클래스 내부에서 사용
- A 클래스 외부에서 A와 함께 사용되는 경우 많음 -> 주로 default / public 접근제한
- B 객체는 A 클래스 내부 어디든 객체를 생성할 수 있음
- A 클래스 외부에서 B 객체를 생성하려면 A 객체 생성 없이 A 클래스로 접근하여 B 객체 생성할 수 있다.

```java
package java_240726.ex01;

public class A {
    // 인스턴스 멤버 클래스
    static class B {}

    // 인스턴스 필드 값으로 B 객체 대입
    B field1 =  new B();

    // 정적 필드 값으로 B 객체 대입
    static B field2 = new B();

    // 생성자
    A() {
        B b = new B();
    }

    // 인스턴스 메소드
    void method1() {
        B b = new B();
    }

    // 정적 메소드
    static void method2() {
        B b = new B();
    }
}

```

```java
package java_240726.ex01;

public class AExample {
    public static void main(String[] args) {
        // B 객체 생성
        A.B b = new A.B();
    }
}

```

- 정적 멤버 클래스 B 내부에는 일반 클래스와 같이 필드, 생성자, 메소드 선언이 올 수 있다.

```java
package java_240726.ex02;

public class A {
    // 정적 멤버 클래스
    static class B {
        // 인스턴스 필드
        int field1 = 1;

        // 정적 필드
        static int field2 = 2;

        // 생성자
        B() {
            System.out.println("B 생성자 실행");
        }

        // 인스턴스 메소드
        void method1() {
            System.out.println("B method1 실행");
        }

        // 정적 메소드
        static void method2() {
            System.out.println("B method2 실행");
        }
    }
}

```

```java
package java_240726.ex02;

public class AExample {
    public static void main(String[] args) {
        // B 객체 생성 및 인스턴스 필드 및 메소드 사용
        A.B b = new A.B();
        System.out.println(b.field1);
        b.method1();

        // B 클래스의 정적 필드 및 메소드 사용
        System.out.println(A.B.field2);
        A.B.method2();
    }
}

```

```java
B 생성자 실행
1
B method1 실행
2
B method2 실행
```

# 9.4 로컬 클래스
- 생성자 또는 메소드 내부에서 아래와 같이 선언된 클래스

![img.png](img.png)

- 로컬 클래스는 생성자와 메소드가 실행될 동안에만 객체를 생성할 수 있다.

```java
package java_240726.ex03;

public class A {
    // 생성자
    A() {
        // 로컬 클래스 선언
        class B {}

        // 로컬 객체 생성
        B b = new B();
    }

    // 메소드
    void method() {
        // 로컬 클래스 선언
        class B {}

        // 로컬 객체 생성
        B b = new B();
    }
}

```

- 로컬 클래스 B 내부에는 필드, 생성자, 메소드 선언, 정적 필드와 정적 메소드 선언 가능
- 