package java_2407.java_240712;


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