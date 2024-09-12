package java_08.java_240823;

public class ThreadNameExample {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread(); // 이 코드 실행하는 스레드 객체 참조 얻기
        System.out.println(mainThread.getName() + " 실행");

        for (int i = 0; i < 3; i++) {
            Thread threadA = new Thread() {
                @Override
                public void run(){
                    // getName 메소드: Thread의 인스턴스 메소드로 스레드 이름 리턴
                    System.out.println(getName() + " 실행");
                }
            };
            threadA.start();
        }

        Thread chatThread = new Thread() {
            @Override
            public void run(){
                System.out.println(getName() + " 실행");
            }
        };
        chatThread.setName("chat-thread"); // 작업 스레드 이름 변경
        chatThread.start();
    }
}
