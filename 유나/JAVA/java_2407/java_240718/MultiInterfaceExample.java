package java_2407.java_240718;

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
