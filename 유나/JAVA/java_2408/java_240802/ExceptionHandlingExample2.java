package java_2408.java_240802;

public class ExceptionHandlingExample2 {
    public static void main(String[] args) {
        String[] array = {"100", "1oo", null, "200"};

        for (int i=0; i <=array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: "+ value);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("배열 인덱스가 초과됨 " + e.getMessage());
            } catch (NullPointerException | NumberFormatException e) {
                // 하나로 처리하고 싶은 경우  |로 묶어줌
                System.out.println("데이터에 문제가 있음: " + e.getMessage());
            }
        }
    }
}
