package devops4.testsMutations;

import java.util.ArrayList;

import org.junit.Before;

import main.UnGame;
import places.Corridor;
import places.Room;

public class FindTest {

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

}
