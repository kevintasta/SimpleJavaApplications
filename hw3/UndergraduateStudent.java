public class UndergraduateStudent extends Student {

    public UndergraduateStudent(String firstName, String lastName,
        int intelligence, int motivation) {
        super(firstName, lastName, intelligence, motivation);
    }

    public String toString() {
        return super.getInfo()
            + "I'm going home this weekend to get"
            + " laundry done; talk about clutch.";
    }
}