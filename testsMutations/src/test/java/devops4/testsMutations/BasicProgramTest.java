package devops4.testsMutations;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/* Ajouter la librairie junit4 au buildpath pour que ça marche */

public class BasicProgramTest {

	private BasicProgram bp;
	
	@Before
	public void setUp() {
		bp = new BasicProgram();
	}
	
	@Test
	public void testDoNothingMethod() {
		assertTrue(bp.doNothing());
	}
	
	@Test
	public void testShouldReturn2() {
		assertEquals(bp.shouldReturn2(),2);
	}
	
	@Test
	public void testShouldBeVisible() {
		assertEquals(bp.shouldBeVisible(),"I am public");
	}

}
