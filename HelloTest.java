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
		assertEquals("Hello, Zeus!\n", stdout.toString());
	}
	@Test
	public void checkOutputWithBadName() {
		Hello.main(new String[]{"xerxes"});
		assertEquals("Hello, Xerxes!\n", stdout.toString());
	}
	@Test
	public void checkOutputWithMeFlagBefore() {
		Hello.main(new String[]{"-meJay","xerxes"});
		assertEquals("Hello, Xerxes!\nI am Jay.\n", stdout.toString());
	}
	@Test
	public void checkOutputWithMeFlagBeforeMulti() {
		Hello.main(new String[]{"-me", "jay", "xerxes"});
		assertEquals("Hello, Xerxes!\nI am jay.", stdout.toString());
	}
	@Test
	public void checkOutputWithMeFlagAfterMulti() {
		Hello.main(new String[]{"xerxes", "-me", "jay"});
		assertEquals("Hello, Xerxes!\nI am jay.", stdout.toString());
	}	@Test
	public void checkOutputWithMeFlagAfter() {
		Hello.main(new String[]{"xerxesI am jay.", "-mejay"});
		assertEquals("Hello, Xerxes!\n", stdout.toString());
	}
}
