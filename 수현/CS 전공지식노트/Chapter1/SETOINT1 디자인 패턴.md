# 디자인 패턴

- 디자인 패턴이란?? 프로그램을 설계할 때 발생했던 문제점들을 객체 간의 상호 관계 등을 이용하여 해결할 수 있도록 하나의 규약 형태로 만들어 놓은 것을 의미!!


## 싱글톤 패턴

1. 설명

- 싱글톤 패턴(singleton pattern)은 하나의 클래스에 오직 하나의 인스턴스만 가지는 패턴
- 보통 데이터베이스 연결 모듈에 많이 사용..
- 하나의 인스턴스를 만들어 놓고 해당 인스턴스를 다른 모듈들이 공유하며 사용하기 때문에 인스턴스를 생성할 때 드는 비용이 줄어드는 장점이 있다
- 하지만 의존성이 높아진다는 장점이 있다

2. 자바에서 예시...

``` java
class Singleton {
    private static class singleInstanceHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    public static synchronized Singleton getInstance() {
        return singleInstanceHolder.INSTANCE;
    }
}

public class HelloWorld {
    public static void main(String[] args) {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        if(a == b) {
            System.out.println(true);
        }
    }
}
```

3. 싱글톤 패턴의 단점

- 싱글톤 패턴은 TDD(Test Driven Developmen)를 할 때 걸림돌이 됩니다. / TDD를 할 때 단위 테스트를 주로 하는데, 단위 테스트는 테스트가 서로 독립적이어야 하며 테스트를 어떤 순서로든 실행할 수 있어야 하지만, 싱글톤 패턴은 미리 생성된 하나의 인스턴스를 기반으로 구현하는 패턴이므로 각 테스트마다 독립적인 인스턴스를 만들기가 어렵다..

4. 의존성 주입

- 사용하기가 쉬고 굉장히 실용적이지만 모듈 간의 결합을 강하게 만들 수 있다는 단점이 있다
- 이대 의존성 주임(DI, Dependency Injection)을 통해 모듈간의 결합을 조금 더 느슨하게 만들어 해결할 수 있다
- 의존성이란 종속성이라고도 하며 A가 B에 의존성이 있다는 것은 B의 변경 사항에 대해 A 또한 변해야 된다는 것을 의미
- 장점 :  모듈들을 쉽게 교체할 수 있는 구조가 되어 테스팅하기 쉬고 마이그레이션하기도 수월하다
- 단점 : 모듈들이 분리되므로 클래스 수가 늘어나 복잡성이 증가될 수 있으며 약간의 런타임 패널티가 생기기도 한다
- 의존성 주입 원칙 : 상위 모듈은 하위 모듈에서 어떠한 것도 가져오지 않아야 한다. 둘 다 추상화에 의존해야 하며, 이때 추상화는 세부 사항에 의존하지 말아야 한다



## 팩토리 패턴

1. 설명

- 객체를 사용하는 코드에서 객체 생성 부분을 떼어내 추상화한 패턴이자 상속 관계에 있는 두 클래스에서 상위 클래스가 중요한 뼈대를 결정하고, 하위 클래스에서 객체 생성에 관란 구체적인 내용을 결정하는 패턴 
- 객체 생성 로직이 따로 떼어져 있기 때문에 코드를 리팩터링하더라도 한 곳만 수정할 수 있으니 유지 보수성이 증가한다

2. 자바에서의 팩토리 패턴
``` java
abstract class coffee {
    public abstract int getPrice();

    @Override
    public String toString() {
        return "Hi this coffee is " + this.getPrice();
    }
}

class CoffeeFactory {
    public static Coffee getCoffee(String type, int price) {
        if ("Latte" .equalsIgnoreCase(type)) return new Latte(price);
        else if ("Americano".equalsIgnoreCase(type)) return new Americano(price);
        else {
            return new DefaultCoffee();
        }
    }
}

class DefaultCoffee extends Coffee {
    private int price;

    public DefaultCoffee() {
        this.price = -1;
    }

    @Override
    publoic int getPrice() {
        return this.price;
    }
}

class Latte extends Coffee {
    private int price;

    public Latte(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}

class Americano extends Coffee {
    private int price;

    public Americano(int price) {
        this.price = price;
    }
    @Override
    public int getPrice() {
        return this.price;
    }
}

public class HelloWorld {
    public static void main(String[] args) {
        Coffee latte = CoffeFactory.getCoffee("Latte", 4000);
        Coffee ame  = CoffeeFactory.getCoffee("Americano", 3000);
        System.out.println("Factory latte ::" + latte);
        System.out.println("Factory ame ::" + ame);
    }
}
```