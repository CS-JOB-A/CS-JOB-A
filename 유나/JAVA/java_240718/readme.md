# 8.8 다중 인터페이스 구현
- 구현 객체는 여러 개의 인터페이스를 implements할 수 있음
- 인터페이스 A와 인터페이스 B를 구현하고 있다면, 각각의 인터페이스를 통해 구현 객체 ㅏ용 가능
- imlemnets 후 쉼표로 구분 가능
- 모든 인터페이스가 가진 추상 메소드를 재정의 해야함

![img_1.png](img_1.png)

- RemoteControl
```java
package java_240718;

public interface RemoteControl {
    // 추상 메소드
    void turnOn();
    void turnOff();
}

```

- Searchable
```java
package java_240718;

public interface Searchable {
    // 추상 메소드
    void search(String url);
}

```

- SmartTelevision
```java
package java_240718;

public class SmartTelevision implements RemoteControl, Searchable {
    // turnOn() 추상 메소드 오바라이딩
    @Override
    public void turnOn(){
        System.out.println("TV를 켭니다.");
    }

    @Override
    public void turnOff(){
        System.out.println("TV를 끕니다.");
    }

    @Override
    public void search(String url){
        System.out.println(url + "을 실행합니다.");
    }

}

```

- MultiInterfaceExample
```java
package java_240718;

public class MultiInterfaceExample {
    public static void main(String[] args) {
        // RemoteControl 인터페이스 변수 선언 및 구현 객체 대입
        RemoteControl rc = new SmartTelevision();

        rc.turnOn();
        rc.turnOff();

        // Searchable 인터페이스 변수 선엄 및 구현 객체 대입
        Searchable searchable = new SmartTelevision();
        searchable.search("https://www.youtube.com");
    }
}

```

- 실행 결과
```java
TV를 켭니다.
TV를 끕니다.
https://www.youtube.com을 실행합니다.
```

# 8.9 인터페이스 상속
- 다중 상속 허용
- extends 키워드 뒤 상속할 인터페이스 나열
- 자식 인터페이스의 구현 클래스는 자식 인터페이스의 메소든 뿐만 아니라 부모 인터페이스의 모든 추상 메소드 재정의해야 함
- 구현 객체는 자식 및 부모 인터페이스 변수에 대입 가능

- InterfaceA
```java
package java_240718;

public interface InterfaceA {
    void methodA();
}

```

- InterfaceB
```java
package java_240718;

public interface InterfaceB {
    void methodB();
}

```

- InterfaceC
```java
package java_240718;

public interface InterfaceC extends InterfaceA, InterfaceB {
    void methodC();
}

```

- InterfaceCImpl
```java
package java_240718;

public class InterfaceCImpl implements InterfaceC {
    public void methodA() {
        System.out.println("InterfaceImpl-methodA() 실행");
    }

    public void methodB() {
        System.out.println("InterfaceImpl-methodB() 실행");
    }

    public void methodC() {
        System.out.println("InterfaceImpl-methodC() 실행");
    }
}

```
- ExtendExample
```java
package java_240718;

public class ExtendExample{
    public static void main(String[] args) {
        InterfaceCImpl impl = new InterfaceCImpl();

        InterfaceA ia = impl;
        ia.methodA();
        System.out.println();

        InterfaceB ib = impl;
        ib.methodB();
        System.out.println();

        InterfaceC ic = impl;
        ic.methodA();
        ic.methodB();
        ic.methodC();
    }
}

```

- 실행 결과
```java
InterfaceImpl-methodA() 실행

InterfaceImpl-methodB() 실행

InterfaceImpl-methodA() 실행
InterfaceImpl-methodB() 실행
InterfaceImpl-methodC() 실행

```