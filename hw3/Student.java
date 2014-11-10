public class Student extends Person {
    private int intelligence;
    private int motivation;
    protected int y = 2;

    public Student() {
        System.out.println(" duper");
    }
    protected String getInfo() {
        return super.toString()
            + "My intelligence is " +  intelligence
            + "/10" + " and my motivation is " + motivation
            + "/10. ";
    }

    public String toString() {
        return this.getInfo()
            + "I'm stressed out. ";
    }
}