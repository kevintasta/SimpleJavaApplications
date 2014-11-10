
public class Tester {

    public static void main(String[] args) {
        Student d = new Student();
        int delta = 1;
        GraduateStudent f = new GraduateStudent(delta);
    }

    static void bar() throws Throwable {
    	throw new Throwable("Wee");
    }

    static void foo() throws Throwable {
    	bar();
    	System.out.println("Foo");
    }
}