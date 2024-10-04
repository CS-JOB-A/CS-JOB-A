## vector
- ArrayList와 동일한 내부 구조
- 동기화된 메소드로 구성되어 있기 때문에 스레드가 동시에 Vector() 메소드 실행할 수 없다는 차이점
- 멀티 스레드 환경에서는 안전하게 객체를 추가 또는 삭제 가능
- 컬렉션 생성 방법은 동일

```java
package java_241004;

import java_241003.Board;

import java.util.List;
import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        // Vector 컬렉션 생성
        List<Board> list = new Vector<>();

        // 작업 스레드 객체 생성
        Thread threadA = new Thread(){
            @Override
            public void run(){
                // 객체 1000개 추가
                for (int i = 1; i <= 1000; i++) {
                    list.add(new Board("제목"+i , "내용"+i, "글쓴이"+i));
                }
            }
        };

        // 작업 스레드 객체 생성
        Thread threadB = new Thread(){
            @Override
            public void run(){
                // 객체 1000개 추가
                for (int i = 1001; i <= 2000; i++) {
                    list.add(new Board("제목"+i , "내용"+i, "글쓴이"+i));
                }
            }
        };

        // 작업 스레드 실행
        threadA.start();
        threadB.start();

        // 작업 스레드들이 모두 종료될 떼까지 메인 스레드를 기다리게 함
        try {
            threadA.join();
            threadB.join();
        } catch (Exception e){}

        // 저장된 총 객체 수 얻기
        int size = list.size();
        System.out.println("총 객체 수: " + size);
        System.out.println();
    }
}

```

```java
총 객체 수: 2000
```