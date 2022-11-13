import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagementPropertyTest {

	Property sampleProperty, sampleProperty2;
	ManagementProperty managementCompany; 
	
	@BeforeEach
	public void setUp() throws Exception {
		managementCompany= new ManagementProperty("Merlyn", "123456", 1000);
		sampleProperty = new Property ("JabbaJunior", "Shanghai", 123, "Merlyn", 2, 5, 2, 2);		 	
		sampleProperty2 = new Property ("Chen Lan Bin", "Taiwan", 234, "Capital City", 0, 0, 1, 1);		 
		
	}

	@AfterEach
	public void tearDown() throws Exception {
		managementCompany=null;
	}

	@Test
	public void testAddProperty() {
		sampleProperty = new Property ("JabbaJunior", "Shanghai", 123, "Merlyn", 2, 5, 2, 2);		 
		assertEquals(managementCompany.addProperty(sampleProperty),0);	
		sampleProperty2 = new Property ("Chen Lan Bin", "Taiwan", 234, "Capital City", 0, 0, 1, 1);		 
		assertEquals(managementCompany.addProperty(sampleProperty),1);
	
	}
	
	@Test
	public void testGetPropertiesCount() {
		sampleProperty = new Property ("Xi Jinping", "Shanghai", 2912, "Merlyn", 2, 5, 2, 2);		 
		assertEquals(managementCompany.addProperty(sampleProperty),0);	
		sampleProperty2 = new Property ("Chen Lan Bin", "Taiwan", 234, "Capital City", 0, 0, 1, 1);		 
		assertEquals(managementCompany.addProperty(sampleProperty),1);
		assertEquals(managementCompany.getPropertiesCount(), 2);
	}

	@Test
	public void getTotalRent() {
		sampleProperty = new Property ("Xi Jinping", "Shanghai", 2912, "Merlyn", 2, 5, 2, 2);		 
		assertEquals(managementCompany.addProperty(sampleProperty),0);	
		assertEquals((int)managementCompany.getTotalRent(), 2912);
	}
	
	public void getTaxID() {
		sampleProperty = new Property ("Xi Jinping", "Shanghai", 2912, "Merlyn", 2, 5, 2, 2);	
		assertEquals(managementCompany.getTaxID(), 2912);
	}

	public void getHighestRentProperty() {
		sampleProperty = new Property ("Xi Jinping", "Shanghai", 2912, "Merlyn", 2, 5, 2, 2);
		sampleProperty2 = new Property ("Chen Lan Bin", "Taiwan", 234, "Capital City", 0, 0, 1, 1);	
		assertEquals(managementCompany.getHighestRentPropperty(), 0);
	}
	
	public String toString() {
		sampleProperty = new Property ("Xi Jinping", "Shanghai", 2912, "Merlyn", 2, 5, 2, 2);
		assertEquals(managementCompany.toString(), "[Xi Jinping],[Shanghai],[2912.0],[Merlyn]");
		return managementCompany.toString();
	}
	
	
}
