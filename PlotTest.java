import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PlotTest {
	
	private Plot plot1, plot2, plot3;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		plot1 = new Plot(2, 2, 6, 6);
		plot2 = new Plot(15, 12, 7, 5);
		plot3 = new Plot(3, 4, 4, 3);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		plot1 = plot2 = plot3 = null;
	}
	
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testOverlaps() {
		assertTrue(plot1.overlaps(plot3));
	}
		
	
	
	// test to string
	@Test
	public void testToString() {
		assertEquals("[2],[2],[6],[6]", "" + plot1);
		assertEquals("[15],[12],[7],[5]", "" + plot2);
		assertEquals("[3],[4],[4],[3]", "" + plot3);
		
	}
}
