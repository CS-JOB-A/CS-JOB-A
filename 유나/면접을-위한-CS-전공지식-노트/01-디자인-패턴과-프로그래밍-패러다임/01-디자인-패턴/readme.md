# Chapter 01. 디자인 패턴과 프로그래밍 패러다임
- 라이브러리 
  - 공통으로 사용될 수 있는 특정한 기능들을 모듈화 한 것
  - 폴더명, 파일명 등에 대한 규칙이 없고 프레임워크에 비해 자유로움
  - 내가 직접 컨트롤한다.
- 프레임워크
  - 공통으로 사용될 수 있는 특정한 기능등을 모듈화 한 것
  - 폴더명, 파일명 등에 대한 규칙이 있고 라이브러리에 비해 좀 더 엄격함
  - 내가 직접 컨트롤 하지 않음

# 1.1 디자인 패턴
- 프로그램을 설계할 때 발생했던 문제점들의 객체 간의 상호 관계 등을 이용하여 해결할 수 있도록 하나의 '규약' 형태로 만들어 놓은 것

# 1.1.1 싱글톤 패턴(singleton pattern)
- 하나의 클래스에 하나의 인스턴스만 가지는 패턴
- 단 하나의 인스턴스. 이를 기반으로 로직을 만드는 데 사용
- 데이터베이스 연결 모듈에 많이 사용
- 장점 : 해당 인스턴스를 다른 모듈들이 공유하며 사용 -> 인스턴스 생성 비용 절감
- 단점 : 의존성이 높아짐

## 자바스크립트의 싱글톤 패턴
- 리터럴 {} 혹은 new Object로 객체를 생성 -> 다른 어떤 객체와도 같지 않기 때문에 싱글톤 패턴 구현 가능

```javascript
const obj = {
    a: 27
}

const obj2 = {
    a: 27
}

console.log(obj === obj2) // false
```

- Singleton.instance라는 하나의 인스턴스를 가지는 Singleton 클래스를 구현
- a와 b는 하나의 인스턴스를 가짐

```javascript
class Singleton {
    constructor() {
        if (!Singleton.instance) {
            Singleton.instance = this
        }
        return Singleton.instance
    }
    getInstance() {
        return this.instance
    }
}

const a = new Singleton()
const b = new Singleton()
console.log(a === b) // true
```

## 자바에서의 싱글톤 패턴

```javascript
package ex01;

public class ex01 {
    class Singleton {
        private static class singleInstanceHolder {
            private static final Singleton INSTANCE = new Singleton();
        }

        public static Singleton getInstance() {
            return singleInstanceHolder.INSTANCE;
        }
    }

    public class HelloWorld {
        public static void main(String[] args) {
            Singleton a = Singleton.getInstance();
            Singleton b = Singleton.getInstance();
            System.out.println(a.hashCode());
            System.out.println(b.hashCode());
            if (a == b) {
                System.out.println(true);
            }
        }
    }
}

```