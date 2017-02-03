public class Hello {
	public static void main(String[] args) {
		if (args.length > 0) {
			print(args[0]);
		} else {
			print();
		}
	}

	public static void print(String name) {
		System.out.println("Hello, "+name+"!");
	}

	public static void print() {
		System.out.println("Hello, Cthulhu!");
	}
}
