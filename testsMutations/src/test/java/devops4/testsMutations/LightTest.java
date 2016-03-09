package devops4.testsMutations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.UnGame;
import places.Corridor;
import places.Room;

public class LightTest {

	private UnGame game;
	private ArrayList<Room> schoolTest;
	private Corridor corridor;

	@Before
	public void setUp() {
		game = new UnGame();
		corridor = new Corridor("", false, false, 0);
		schoolTest = game.getSchoolMap();
		for (int i = 0; i < schoolTest.size(); i++) {
			if (schoolTest.get(i) instanceof Corridor) {
				corridor = (Corridor) schoolTest.get(i);
			}
		}
	}

	@Test
	public void isTheLightCanBeSwitched() {
		assertFalse(schoolTest.isEmpty());
		game.getSchoolClass().get(0).setHaveKey(false);
		assertFalse(game.getSchoolClass().get(0).isHaveKey());
		// First step, we locked the corridor and the student doesn't have a key
		corridor.setIsLocked(true);
		corridor.action(game.getSchoolClass().get(0));
		assertFalse(corridor.isLight());

		corridor.setNbStudent(0);
		// Secondly, we open the corridor, the student can switch on the light
		corridor.setIsLocked(false);
		assertFalse(corridor.isLocked());
		corridor.action(game.getSchoolClass().get(0));
		assertEquals(corridor.getNbStudent(), 1);
		assertTrue(corridor.isLight());
		corridor.setNbStudent(0);
	}

	@Test
	public void actionTest() {
		corridor.action(game.getSchoolClass().get(0));
		corridor.setIsLocked(true);
		// Empty room and not light
		corridor.setNbStudent(0);
		corridor.setLight(false);
		game.getSchoolClass().get(0).setHaveKey(false);
		// Cannot access to the room, and the room is empty.
		// The room should not be lit.
		assertFalse(corridor.isLight());
	}

	@Test
	public void addTest() {
		corridor.setNbStudent(0);
		corridor.addStudent();
		assertEquals(corridor.getNbStudent(), 1);
	}

	@Test
	public void leaveTest() {
		corridor.setNbStudent(2);
		corridor.leave();
		corridor.leave();
		assertEquals(corridor.getNbStudent(), 0);
		// The last student should have switch off the light and locked the
		// corridor.
		assertFalse(corridor.isLight());
		assertTrue(corridor.isLocked());
	}

	
}
