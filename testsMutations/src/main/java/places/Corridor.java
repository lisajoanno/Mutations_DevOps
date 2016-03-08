package places;

import java.util.Random;

import data.CorridorNames;
import people.Student;

/**
 * The corridor class
 *
 */
public class Corridor extends LightableRoom {

	private int randNumber;
	private Random rand;

	/**
	 * The constructor of the class
	 * 
	 * @param name
	 * @param light
	 */
	public Corridor(String name, boolean light, boolean thereIsAKey,
			int nbStudent) {
		super(name, false, light, thereIsAKey, nbStudent); // a corridor is
															// never locked
	}

	public void search(Student theStudent) {
		if (!this.isLight()) {
			System.out
					.println("The student can't see anything. It is too dark.");
		} else {
			if ((!this.isHaveAnObject())) {
				System.out.println("The student found nothing.");
			} else {
				System.out.println("The student found a key !");
				theStudent.setHaveKey(true);
			}
		}
	}

	/**
	 * A method to create a Corridor with a random method
	 *
	 */
	public void initCorridor() {
		rand = new Random();
		randNumber = rand.nextInt(CorridorNames.values().length);
		this.setName(CorridorNames.values()[randNumber].toString());
		randNumber = rand.nextInt(2);
		if (randNumber == 1) {
			this.setLight(false);
		}
		randNumber = rand.nextInt(3);
		this.setNbStudent(randNumber);
	}

	@Override
	public String toString() {
		return "The " + getName() + " is lit : " + isLight() + ". There is "
				+ getNbStudent() + " students.";
	}

}
