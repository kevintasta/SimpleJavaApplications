public class Person {
    private String firstName, lastName;
    protected int x = 1;

    public Person() {
    	System.out.println("Super");
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return "Hi, my name is "
            + firstName + " " + lastName + ". ";
    }

    public void speak() {
    	System.out.println("Person");
    }
}