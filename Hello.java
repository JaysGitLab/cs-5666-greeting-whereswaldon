public class Hello {
    	private static String name = "Jeeves";
    	private static String friend = "";

	public static void main(String[] args) {
		setArgs(args);
                print(friend);
		introduce();
		ask();
	}

        /**
        setArgs parses the command line arguments to set global state.
        */
	private static void setArgs(String[] args) {
    		name = "Jeeves";
    		friend = "";
		if (args.length > 0) {
            		for (int i = 0; i < args.length; i++) {
                		String arg = args[i];
                		if (arg.startsWith("-me")) {
                                        if (arg.length() > 3) {
                                                name = arg.substring(3);
                                        } else {
                                                name = args[i+1];
                                                i++;
                                        }
                		} else {
                    			friend = arg;
                		}
        		}
		}
	}

        /**
        introduce prints an introduction from the program.
        */
	private static void introduce() {
    		System.out.println("I am "+name+".");
	}

	/**
	ask asks the user a question
	*/
	private static void ask() {
		System.out.println("How are you?");
	}

        /**
        capitalize ensures that the first letter of a string is capitalized.
        */
	private static String capitalize(String name) {
    		return name.charAt(0) < 'A' || name.charAt(0) > 'Z'
        		? ("" + name.charAt(0)).toUpperCase() + name.substring(1)
        		: name;
	}

	/**
	print greets the user with the provided name.
	*/
	public static void print(String name) {
    		if (! name.equals("")) {
        		System.out.println("Hello, "+capitalize(name)+"!");
    		} else {
        		System.out.println("Hello, Cthulhu!");
    		}
	}
}
