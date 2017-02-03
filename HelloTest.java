import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HelloTest {
	private static ByteArrayOutputStream stdout = new ByteArrayOutputStream();
	private static PrintStream originalOut;
	@Before
	public void captureOutput() {
		originalOut = System.out;
		stdout = new ByteArrayOutputStream();
		System.setOut(new PrintStream(stdout));
	}
	@After
	public void releaseOutput() {
		System.setOut(originalOut);
	}
	@Test
	public void checkOutput() {
		Hello.main(new String[]{});
		assertEquals("Hello, Cthulhu!\n", stdout.toString());
	}
	@Test
	public void checkOutputWithName() {
		Hello.main(new String[]{"Zeus"});
		assertEquals("Hello, Cthulhu!\n", stdout.toString());
	}
}
