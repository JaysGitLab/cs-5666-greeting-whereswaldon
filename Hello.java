public class Hello {
	public static void main(String[] args) {
		if (args.length > 0) {
			print(args[0]);
		} else {
			print();
		}
	}

	public static void print(String name) {
    		String first = ("" + name.charAt(0)).toUpperCase();
		System.out.println("Hello, "+first + name.substring(1)+"!");
	}

	public static void print() {
		System.out.println("Hello, Cthulhu!");
	}
}
