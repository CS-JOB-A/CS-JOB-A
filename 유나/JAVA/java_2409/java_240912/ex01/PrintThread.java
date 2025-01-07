package java_2409.java_240912.ex01;

public class PrintThread extends Thread {
    private boolean stop;

    // 외부에서 stop 필드값을 변견할 수 있도록 Setter 선언
    public void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public void run() {
        // stop 필드값에 따라 반복 여부 결정
        while (!stop) {
            System.out.println("실행중");
        }
        System.out.println("리소스 정리"); // 리소스 정리
        System.out.println("실행 종료");
    }
}
