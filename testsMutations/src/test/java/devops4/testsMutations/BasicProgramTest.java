package devops4.testsMutations;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/* Ajouter la librairie junit4 au buildpath pour que ça marche */

public class BasicProgramTest {

	private BasicProgram bp = new BasicProgram();

	@Test
	public void testDoNothingMethod() {
		assertTrue(bp.doNothing());
	}

}
