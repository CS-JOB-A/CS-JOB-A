package java_241231;

import java.util.*;
public class HashSetExample2 {
    public static void main(String[] args) {
        // HashSet 컬렉션 생성
        Set<Member> set =  new HashSet<Member>();

        // Member 객체 저장
        set.add(new Member("김영웅", 30));
        set.add(new Member("김영웅", 30)); // 인스턴스는 다르지만 동등 객체로 1개만 저장

        // 저장된 객체 수 출력
        System.out.println();
    }
}
