package places;

import java.util.Random;

import people.Student;

/**
 * The office class
 *
 */
public class Office extends LightableRoom {

	private int randNumber;
	private Random rand;

	/**
	 * The constructor of the class
	 * 
	 * @param name
	 * @param isLocked
	 * @param light
	 * @param haveAnObject
	 */
	public Office(String name, boolean isLocked, boolean light, boolean thereIsDigicodeSolution, int nbStudent) {
		super(name, isLocked, light, thereIsDigicodeSolution, nbStudent);
	}

	/**
	 * Method to find an object in the office (if there is one)
	 * 
	 * @param theStudent
	 */
	public void search(Student theStudent) {
		if (!(this.isLocked()) && this.isLight() && this.isHaveAnObject()) {
			theStudent.setHaveDigicode(true);
		}
	}

	/**
	 * A method to create an office with a random method
	 */
	public void initOffice() {
		rand = new Random();
		this.setName("Office");
		randNumber = rand.nextInt(2);
		if (randNumber == 1) {
			this.setIsLocked(false);
		}
		randNumber = rand.nextInt(2);
		if (randNumber == 1) {
			this.setLight(false);
		}
		randNumber = rand.nextInt(2);
		if (randNumber == 1) {
			this.setHaveAnObject(true);
		}
		randNumber = rand.nextInt(3);
		this.setNbStudent(randNumber);
	}

	@Override
	public String toString() {
		return "You are in the office. The office is locked : " + isLocked() + ". The office is lit : " + isLight()
				+ ".";
	}

}
