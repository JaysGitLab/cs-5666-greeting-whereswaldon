import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HelloTest {
	private static ByteArrayOutputStream stdout = new ByteArrayOutputStream();
	private static ByteArrayOutputStream stderr = new ByteArrayOutputStream();
	@Before
	public void captureOutput() {
		System.setOut(new PrintStream(stdout));
		System.setErr(new PrintStream(stderr));
	}
	@Test
	public void checkOutput() {
	}
	@After
	public void releaseOutput() {
		System.setOut(null);
		System.setErr(null);
	}
}
