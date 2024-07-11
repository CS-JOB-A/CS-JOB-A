# 8.5 디폴트 메소드
- 인터페이스는 완전한 실행 코드를 가진 디폴트 메소드 선언 가능
- 디폴트 메소드는 실행부 존재
- default 키워드가 리턴 타입 앞에 붙음
- 디폴트 메소드는 구현 객체가 필요한 메소드 -> 구현 객체를 인터페이스 변수에 대입하여 호출해야함

---
- RemoteControl
```java
package java_240710;

public interface RemoteControl {
    // 상수 필드
    int MAX_VOLUME = 10;
    int MIN_VOLUME = 0;

    // 추상 메소드
    void turnOn();
    void turnOff();
    void setVolume(int volume);

    // 디폴트 인스턴스 메소드
    default void setMute(boolean mute) {
        if (mute) {
            System.out.println("무음 처리 합니다.");
            // 추상 메소드 호출하면서 상스 필드 사용
            setVolume(MIN_VOLUME);
        } else{
            System.out.println("무음 해제합니다");
        }
    }
}
```
- Television
```java
package java_240710;

public class Television implements RemoteControl {
    // 필드
    private int volume;


    // 인터페이스에 선언된 추상 메소드 재정의
    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다.");
    }
    @Override
    public void turnOff() {
        System.out.println("TV를 끕니다.");
    }
    @Override
    public void setVolume(int volume) {
        if (volume > RemoteControl.MAX_VOLUME) {
            this.volume = RemoteControl.MAX_VOLUME;
        } else{
            if (volume < RemoteControl.MIN_VOLUME){
                this.volume = RemoteControl.MIN_VOLUME;
            } else {
                this.volume = volume;
            }
        }
        System.out.println("현재 오디오 볼륨: " + volume);
    }
}
```
- RemoteControlExample
```java
package java_240710;

public class RemoteControlExample {
    public static void main(String[] args) {
        // 인터페이스 변수 선언
        RemoteControl rc;

        // Television 객체를 생성하고 인터페이스 변수에 대입
        rc =  new Television();
        rc.turnOn();
        rc.setVolume(5);

        // 디폴트 메소드 호출
        rc.setMute(true);
        rc.setMute(false);
    }
}

```

- 실행 결과
```java
TV를 켭니다.
현재 오디오 볼륨: 5
무음 처리 합니다.
현재 오디오 볼륨: 0
무음 해제합니다

```

---
- 디폴트 메소드를 재정의하여 자신에게 맞게 수정 가능
- 재정의시 public 접근 제한자 필수, default 생략

---
- Audio
```java
package java_240710;

public class Audio implements RemoteControl {
    // 필드
    private int volume;

    // turnOn 추상 메소드 재정의
    @Override
    public void turnOn() {
        System.out.println("Audio를 켭니다.");
    }
    // turnOff 추상 메소드 재정의
    @Override
    public void turnOff() {
        System.out.println("Audio를 끕니다.");
    }
    // setVolume 추상 메소드 오버라이딩
    @Override
    public void setVolume(int volume) {
        if (volume > RemoteControl.MAX_VOLUME) {
            this.volume = RemoteControl.MAX_VOLUME;
        } else{
            if (volume < RemoteControl.MIN_VOLUME){
                this.volume = RemoteControl.MIN_VOLUME;
            } else {
                this.volume = volume;
            }
        }
        System.out.println("현재 오디오 볼륨: " + volume);
    }

    // 필드
    private int memoryVolume; // 추가 필드 선언

    // 디폴트 메소드 재정의
    @Override
    public void setMute(boolean mute) {
        if (mute) {
            this.memoryVolume = this.volume;
            System.out.println("무음 처리합니다.");
            setVolume(RemoteControl.MIN_VOLUME);
        } else {
            System.out.println("무음 해제합니다.");
            setVolume(this.memoryVolume); // mute가 false일 경우, 어ㅜㄴ래 볼륨으로 복원하는 코드
        }
    }
}

```
- RemoteControlExample
```java
package java_240710;

public class RemoteControlExample {
    public static void main(String[] args) {
        // 인터페이스 변수 선언
        RemoteControl rc;

        // Television 객체를 생성하고 인터페이스 변수에 대입
        rc =  new Television();
        rc.turnOn();
        rc.setVolume(5);

        // 디폴트 메소드 호출
        rc.setMute(true);
        rc.setMute(false);

        System.out.println();

        // Audio 개게 생성 후 인터페이스 변수에 대입
        rc = new Audio();
        rc.turnOn();
        rc.setVolume(5);

        // 디폴트 메소드 호출
        rc.setMute(true);
        rc.setMute(false);
    }
}

```

- 실행 결과
```java
TV를 켭니다.
현재 오디오 볼륨: 5
무음 처리 합니다.
현재 오디오 볼륨: 0
무음 해제합니다

Audio를 켭니다.
현재 오디오 볼륨: 5
무음 처리합니다.
현재 오디오 볼륨: 0
무음 해제합니다.
현재 오디오 볼륨: 5
```