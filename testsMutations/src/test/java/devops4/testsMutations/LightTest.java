package devops4.testsMutations;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.UnGame;
import places.LightableRoom;
import places.Room;

public class LightTest {

	private UnGame game;

	@Before
	public void setUp() {
		game = new UnGame();
	}

	@Test
	public void isTheLastStudentSwitchOffTheLight() {
		ArrayList<Room> schoolTest = game.getSchoolMap();
		assertFalse(schoolTest.isEmpty());
	}

}
