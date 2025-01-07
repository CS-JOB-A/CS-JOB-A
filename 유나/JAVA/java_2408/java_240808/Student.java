package java_2408.java_240808;

public class Student {
    private int no;
    private String name;

    public Student(int no, String name) {
        this.no  = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }
    public String getName() {
        return  name;
    }

    /**
     * Object의 hashCode() 메소드를 재정의
     * 학생 번호 + 이름 해시코드 = 새로운 해시코드
     * 번호와 이름이 같으면 동일한 해시코드 생성
     */
    @Override
    public int hashCode(){
        int hashCode = no + name.hashCode();
        return hashCode;
    }

    /**
     * Object의 equals 재정의
     * Student 객체인지 확인, 학생 번호와 이름이 같으면 true 리턴
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student target) {
            if(no == target.getNo() && name.equals(target.getName())) {
                return true;
            }
        } return false;
    }
}
