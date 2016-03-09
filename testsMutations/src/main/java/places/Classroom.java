package places;

import java.util.Random;

import data.RoomNames;
import people.Student;

/**
 * The classroom class
 *
 */
public class Classroom extends UnlightableRoom {

	private int randNumber;
	private Random rand;

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param isLocked
	 */
	public Classroom(String name, boolean isLocked, int nbStudent) {
		super(name, isLocked, nbStudent);
	}

	/**
	 * If the student have a key, he can open the classroom door
	 */
	public void action(Student theStudent) {
		if (this.isLocked() && theStudent.isHaveKey())
			this.enter();
		else if (!this.isLocked())
			this.enter();

	}

	/**
	 * A method to create a Classroom with a random method
	 *
	 */
	public void initClassroom() {
		rand = new Random();
		randNumber = rand.nextInt(RoomNames.values().length);
		this.setName(RoomNames.values()[randNumber].toString());
		randNumber = rand.nextInt(2);
		if (randNumber == 1) {
			this.setIsLocked(false);
		}
		randNumber = rand.nextInt(3);
		this.setNbStudent(randNumber);
	}

	@Override
	public String toString() {
		return "The " + getName() + " classroom is locked : " + isLocked() + ". There is " + getNbStudent()
				+ " students in the class.";
	}

}
