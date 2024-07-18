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
