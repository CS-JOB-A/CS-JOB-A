package java_241231;

public class Member {
    public String name;
    public int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // hashCode 재정의
    @Override
    public int hashCode() {
        // name과 age 값이 같으면 동일한 hashCode 리턴
        return name.hashCode() + age;
    }

    // equals 재정의
    @Override
    public boolean equals(Object obj) {
        // name과 age 값이 같으면 true가 리턴
        if (obj instanceof Member target) {
            return target.name.equals(name) &&  (target.age == age);
        } else {
            return  false;
        }
    }
}
