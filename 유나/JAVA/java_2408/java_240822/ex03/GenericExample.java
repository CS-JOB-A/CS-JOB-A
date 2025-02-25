package java_2408.java_240822.ex03;

public class GenericExample {
    // 제네릭 메소드
    public static <T> Box<T> boxing(T t) { // 타입 파라미터 T 정의
        Box<T> box = new Box<T>();
        box.set(t);
        return box;
    }

    public static void main(String[] args) {
        // 제네릭 메소드 호출
        Box<Integer> box1 = boxing(7);
        int intValue = box1.get();
        System.out.println(intValue);

        // 제네릭 메소드 호출
        Box<String> box2 = boxing("이재현");
        String strValue = box2.get();
        System.out.println(strValue);
    }
}
