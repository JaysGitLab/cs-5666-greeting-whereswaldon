import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertTrue;
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
		assertTrue(stdout.toString().startsWith("Hello, Cthulhu!\n"));
	}
	@Test
	public void checkOutputWithName() {
		Hello.main(new String[]{"Zeus"});
		assertTrue(stdout.toString().startsWith("Hello, Zeus!\n"));
	}
	@Test
	public void checkOutputWithBadName() {
		Hello.main(new String[]{"xerxes"});
		assertTrue(stdout.toString().startsWith("Hello, Xerxes!\n"));
	}
	@Test
	public void checkOutputWithMeFlagBefore() {
		Hello.main(new String[]{"-meJay","xerxes"});
		assertTrue(stdout.toString().startsWith("Hello, Xerxes!\nI am Jay.\n"));
	}
	@Test
	public void checkOutputWithMeFlagBeforeMulti() {
		Hello.main(new String[]{"-me", "jay", "xerxes"});
		assertTrue(stdout.toString().startsWith("Hello, Xerxes!\nI am jay.\n"));
	}

	@Test
	public void checkOutputWithMeFlagAfter() {
		Hello.main(new String[]{"xerxes", "-mejay"});
		assertTrue(stdout.toString().startsWith("Hello, Xerxes!\nI am jay.\n"));
	}
	@Test
	public void checkOutputWithMeFlagAfterMulti() {
		Hello.main(new String[]{"xerxes", "-me", "jay"});
		assertTrue(stdout.toString().startsWith("Hello, Xerxes!\nI am jay.\n"));
	}
}
