public class Tester {
    public static void main (String[] args) {
        ArrayWrapper<String> test = new ArrayWrapper<String>();
        test.add(null);
        System.out.println(test);
        System.out.println(test.size());
    }
}