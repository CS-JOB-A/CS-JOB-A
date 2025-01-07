package java_2408.java_240822.ex04;

public class GenericExample {
    public static void main(String[] args) {
        // 모든 사람이 신청 가능
        Cource.registerCourse1(new Applicant<Person>(new Person()));
        Cource.registerCourse1(new Applicant<Worker>(new Worker()));
        Cource.registerCourse1(new Applicant<Student>(new Student()));
        Cource.registerCourse1(new Applicant<HighStudent>(new HighStudent()));
        Cource.registerCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));
        System.out.println();

        // 학생만 신청 가능
//        Cource.registerCourse2(new Applicant<Person>(new Person()));
//        Cource.registerCourse2(new Applicant<Worker>(new Worker()));
        Cource.registerCourse2(new Applicant<Student>(new Student()));
        Cource.registerCourse2(new Applicant<HighStudent>(new HighStudent()));
        Cource.registerCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));
        System.out.println();

        // 직장인 및 일반인만 신청 가능
        Cource.registerCourse3(new Applicant<Person>(new Person()));
        Cource.registerCourse3(new Applicant<Worker>(new Worker()));
//        Cource.registerCourse3(new Applicant<Student>(new Student()));
//        Cource.registerCourse3(new Applicant<HighStudent>(new HighStudent()));
//        Cource.registerCourse3(new Applicant<MiddleStudent>(new MiddleStudent()));
        System.out.println();
    }
}
