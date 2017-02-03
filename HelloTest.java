import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HelloTest {
	private static ByteArrayOutputStream stdout = new ByteArrayOutputStream();
	@Before
	public void captureOutput() {
		System.setOut(new PrintStream(stdout));
	}
	@Test
	public void checkOutput() {
		Hello.print();
		assertEquals("Hello, Cthulhu!\n", stdout.toString());
	}
	@After
	public void releaseOutput() {
		System.setOut(null);
	}
}
