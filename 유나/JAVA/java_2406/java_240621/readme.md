# 6.15 싱글톤 패턴
## 싱글톤 패턴 (Singletone)
- 생성자를 private 접근 제한해서 외부에서 new 연산자로 생성자를 호출할 수 없도록 막는 것
- 애플리케이션 전체에서 단 한 갸의 객체만 생성하서 사용하고 싶은 경우
- 외부에서 객체 생성 X 싱글톤 패턴이 제공하는 메소드로 간접적으로 객체를 얻을 수 있음

```java
package java_2406.java_240621;

public class Singleton {
    // private 접근 권한을 갖는 정적 필드 선언과 초기화 - 외부에서 정적 필드값 변경하지 못하도록 함
    private static Singleton singleton = new Singleton();

    // private 접근 권환을 갖는 생성자 선언
    private Singleton() {

    }

    // public 접근 권한을 갖는 정적 메소드 선언 - 정적 필드값을 리턴
    public static Singleton getSingleton() {
        return singleton;
    }
}
```

```java
package java_2406.java_240621;

public class SingletoneExample {
    public static void main(String[] args) {
//        Singleton obj1 =  new Singleton(); == 컴파일 에러

        // 정적 메소드 호출해서 싱글톤 객체 얻음
        Singleton obj1 = Singleton.getSingleton();

    }
}

```
## 싱글톤의 장점
1. 접근성 : 전역저으로 접근 가능한 인스턴스 제공 -> 코드 단순화. 복잡도 낮춤
2. 메모리 절약 : 단 하나의 인스턴스 생성 -> 인스턴스 생성 x로 메모리오 CPU 자원 소비 낮춤
3. 데이터 일관성 보장

## 안티패턴 측면의 Singleton
- 안티 패턴  
  - 설계상의 문제로 인해 소프트웨어 시스템이 예상대로 작동하지 않거나 유지보수하기 어렵게 만드는 디자인 패턴

1. 테스트의 어려움
   - 자원 공유 -> 서로 독립적이어야 하는 단위 테스트 진행에 문제
2. 상속의 어려움
    - private로 생성 -> 자바의 장점인 다형성 적용 X
3. 의존성 높아짐
   - 클래스의 객체를 미리 생성한 뒤 필요한 경우 정적 메서드 이용 -> 높은 결합
   - 싱글톤 인스턴스 변경시 해당 인스턴스 참조하는 모든 클래스 수정 필요
4. 객체의 수명주기 제어하기 어려움
   - 객체의 생성가 소멸을 개발자가 직접 제어할 수 없음
   - 객체 생성 시점과 소멸 시점에 대한 유연성이 떨어짐
