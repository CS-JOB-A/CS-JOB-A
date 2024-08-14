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


## 전략 패턴

1. 설명

- 정책 패턴이라고도 하며, 객체의 행위를 바꾸고 싶은 경우 '직접' 수정하지 않고 전략이라고 부르는 '캡슐화한 알고리즘'을 컨텍스트안에서 바꿔주면서 상호 교체가 가능하게 만드는 패턴
- 예제 너무 길어서 생략... 


## 옵저버 패턴

1. 설명

- 주체가 어떤 객체의 상태 변화를 관찰하다가 상태 변화가 있을 때마다 메서드 등을 통해 옵저버 목록에 있는 옵저버들에게 변화를 알려주는 디자인 패턴
- 주체 : 객체의 상태 변화를 보고 있는 관찰자
- 옵저버들 : 이 객체의 상태 변화에 따라 전달되는 메서드 등을 기반으로 '추가 변화 사항'이 생기는 객체들
- 옵저버 패턴을 활용한 서비스로는 트위터가 있다!!
- 옵저버 패턴은 주로 이벤트 기반 시스템에 사용하며 MVC(Model - View - Controller) 패턴에도 사용된다


2. 자바에서는 옵저버 패턴

``` java

interface Subject {
    public void register(Observer obj);
    public void unregist(Observer obj);
    public void notifyObservers();
    public Object getUpdate(Observer obj);
}

interface Observer {
    public void update();
}

class Topic implements Subjectt {
    private List<Observer> observers;
    private String message;

    public Topic() {
        this.observers = new ArrayList<>();
        this.message = "";
    }

    @Override
    public void register(Observer obj) {
        if (!observers.contains(obj)) observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        this.observers.forEach(Observer::update);
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    public void postMessage(String msg) {
        System.out.println("Message sended to Topic: " + msg);
        this.message = msg;
        notifyObservers();
    }
}

class TopicSubscriber implements Observer {
    private String name;
    private Subject topic;

    public TopicSubscriber(String name, Subject topic) {
        this.name = name;
        this.topic = topic;
    }

    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        System.out.println(name + ";; got message >> " + msg);
    }
}

public class HelloWorld {
    public static void main(String[] args) {
        Topic topic = new Topic();
        Observer a = new TopicSubscriber("a", topic);
        Observer b = new TopicSubscriber("b", topic);
        Observer c = new TopicSubscriber("c", topic);
        topic.register(a);
        topic.register(b);
        topic.register(c);

        topic.postMessage("amumu is op champion!!");
    }
}
```


## 프록시 패턴과 프록시 서버

1. 프록시 패턴 

- 대상 객체에 접근하기 전 그 접근에 대한 흐름을 가로채 대상 객체 앞단의 인터페이스 역할을 하는 디자인 패턴
- 객체의 속성, 변환 등을 보완하며 보안, 데이터 검증, 캐싱, 로깅에 사용합니다

2. 프록시 서버

- 서버와 클라이언트 사이에서 클라이언트가 자신을 통해 다른 네트워크 서비스에 간접적으로 접속할 수 있게 해주는 컴퓨터 시스템이나 응용 프로그램을 가르킵니다
- nginx는 비동기 이벤트 기반의 구조와 다수의 연결을 효과적으로 처리 가능한 웹 서버이며, 주로 Node.js 서버 앞단의 프록시 서버로 활용됩니다
- nginx를 프록시 서버로 둬서 실제 포트를 숨길 수 있고 정적 자원을 gzip 압축하거나, 메인 서버 앞단에서의 로깅을 할 수도 있습니다
- 프록시 서버로 쓰는 CloudFlare : 전세계적으로 분산된 서버가 있고 이를 통해 어떠한 시스템의 콘텐츠 전달을 빠르게 할 수 있는 CDN 서비스 입니다
- HTTPS 구축 : 서버에서 HTTPS를 구축할 때 인증서를 기반으로 구축하는데 CloudFlare를 사용하면 별돟의 인증서 설치 없이 좀 더 손쉽게 HTTPS를 구축할 수 있다


## 이터레이터 패턴

1. 설명 

- 이터레이터를 사용하여 컬렉션의 요소들에 접근하는 디자인 패턴
- 이를 통해 순회할 수 있는 여러 가지 자료형의 구조와는 상관없이 이터레이터라는 하나의 인터페이스로 순회가 가능하다


## 노출모듈 패턴

1. 설명

- 즉시 실행 함수를 통해 private, public 같은 접근 제어자를 만드는 패턴을 말함
- 자바스크립트는 private나 public 같은 접근 제어자가 존재하지 않고 전역 범위에서 스크립트가 실행 

## MVC 패턴

1. 설명

- 모델, 뷰, 컨트롤러로 이루어딘 디자인 패턴
- 애플리케이션의 구성 요소를 세 가지 역할로 구분하여 개발 프로세스에서 각각의 구성 요소에만 집중해서 개발할 수 있다
- 재사용성과 확장성이 용이하다는 장점이 있고, 애플리케이션이 복잡해질수록 모델과 뷰의 관계가 복잡해지는 단점이 있다      
- 모델 : 애플리케이션의 데이터인 데이터베이스, 상소, 변수
- 뷰 : 사용자 인터페이스 요소(사용자가 볼 수 있는 화면)
- 컨트롤러 : 하나 이상의 모델과 하나 이상의 뷰를 잇는 다리 역할을 하며 이벤트 등 메인 로직을 담당
- MVC 패턴을 이용한 대표적인 라이브러리  : 리액트

2. MVP 패턴

- MVP 패턴은 MVC 패턴으로부터 파생되었으며 MVC에서 C에 해당하는 컨트롤러가 프레젠터(presenter)로 교체된 패턴!
- 뷰와 프레젠터는 일대일 관계이기 때문에 MVC 패턴보다 더 강한 결합을 지닌 디자인 패턴

3. MVVM 패턴

- MVC의 C에 해당하는 컨트롤러가 뷰모델(view model)로 바뀐 패턴
- 뷰모델은 뷰를 더 추상화한 계층이며, MVVM 패턴은 MVC 패턴과는 다르게 커맨드와 데이터 바인딩을 가지는 것이 특징
- 뷰와 뷰모델 사이의 양방향 데이터 바인딩을 지원하며 UI를 별도의 코드 수정 없이 재사용할 수 있고 단위 테스팅하기 쉰다는 장점이 있다
- 대표적인 프레임워크 : 뷰 (Vue.js) -> watch와 computed 등으로 쉽게 반응형적인 값들을 구축할 수 있다

