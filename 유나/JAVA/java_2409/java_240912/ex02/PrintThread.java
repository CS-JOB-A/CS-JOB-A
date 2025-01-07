package java_2409.java_240912.ex02;

public class PrintThread extends Thread {
    public void run() {
        try {
            while (true) {
                System.out.println("실행 중");
                // 일시 정지 (Interrupted Exception 발생하도록)
                Thread.sleep(1);
            }
        }catch (InterruptedException e) {}
        System.out.println("리소스 정리");
        System.out.println("실행 종료");
    }
}
