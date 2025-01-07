package java_2409.java_240912.ex01;

public class SafeStopExample {
    public static void main(String[] args) {
        PrintThread printThread = new PrintThread();
        printThread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){}

        // PrintThread 를 종료하기 위해 sop 필드값 변경
        printThread.setStop(true);
    }
}
