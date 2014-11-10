public class PersonList {
    private Person[] people;
    private int count = 0;

    public PersonList(int maxSize) {
        people = new Person[maxSize];
    }

    public void listPeople() {
        for (Person person : people) {
            if (person != null) {
                System.out.println(person);
            }
        }
    }

    public void add(Person p) {
        if (count > (people.length - 1)) {
            Person[] temp = new Person[count + 1];
            for (int i = 0; i < people.length; i++) {
                temp[i] = people[i];
            }
            people = temp;
        }
        people[count] = p;
        count++;
    }
}