
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PropertyTestGFA {
	Property propertyOne;

	@BeforeEach
	void setUp() throws Exception {
		propertyOne = new Property("KingKamran Castle", "Rockville", 2500.00, "Merlyn Global Group");
		
	}

	@AfterEach
	void tearDown() throws Exception {
		propertyOne = null;
	}

	@Test
	void testGetPropertyName() {
		assertEquals("KingKamran Castle", propertyOne.getPropertyName());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(2500.00, propertyOne.getRentalAmount());
	}

	@Test
	void testgetCity() {
		assertEquals("Rockville", propertyOne.getCity());
	}
	

	@Test
	void testToString() {
		assertEquals("[KingKamran Castle],[Rockville],[2500.0],[Merlyn Global Group]", "" + propertyOne.toString());	
	}

}
