package java_240726.ex07;

public class Button {
    // 정적 멤버 인터페이스. 중첩 인터페이스 선언
    public static interface ClickListener {
        // 추상 메소드
        void onClick();
    }

    // 중첩 인터페이스 타입으로 필드와 Setter 선언
    // 필드
    private ClickListener clickListener;

    // 메소드
    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    // Button 클릭시 실행하는 메소드 선언
    public void click() {
        this.clickListener.onClick();
    }
}
