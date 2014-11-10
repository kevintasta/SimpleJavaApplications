public class GraduateStudent extends Person {
	private int z, y;
	
	public GraduateStudent() {
		this(0);
	}

	public GraduateStudent(int n) {
		z = x + y +n;
		System.out.println(" fly times " + z);
	}

    public void speak() {
    	System.out.println("Grad");
    }
}