package places;

import java.util.Random;

import data.RoomNames;
import people.Student;

/**
 * The lab class
 * 
 */
public class Lab extends UnlightableRoom {
	private int r;
	private Random rand;
	private String code;
	private String myCode;
	private int randNumber;

	/**
	 * The constructor of the class
	 * 
	 * @param name
	 * @param isLocked
	 * @param code
	 */
	public Lab(String name, boolean isLocked, String code, int nbStudent) {
		super(name, true, nbStudent);
		this.code = code;
	}

	/**
	 * A student can open a lab door if he got the digicode solution. If not, he
	 * can try a random code
	 */
	public void action(Student theStudent) {
		if (this.isLocked()) {
			if (!(theStudent.isHaveDigicode())) {
				digicode();
			} else {
				this.enter();
				System.out.println("The student is in the " + this.getName() + " lab.");
			}
		} else {
			this.enter();
			System.out.println("The student is in the " + this.getName() + " lab.");
		}
	}

	/**
	 * A method to open a lab door if the student have not the digicode
	 * 
	 */
	public void digicode() {
		r = 0;
		rand = new Random();
		myCode = "";
		for (int i = 0; i < 4; i++) {
			r = 1 + rand.nextInt(4);
			myCode += r;
		}
		System.out.println("The student tries the combination : " + myCode);
		if (myCode.equals(this.getCode())) {
			this.enter();
			System.out.println("The student is in the " + this.getName() + " lab.");
		} else {
			System.out.println("The student failed to open the door !");
		}
	}

	/**
	 * A method to create a Lab with a random method
	 * 
	 */
	public void initLab() {
		rand = new Random();
		String digicode = "";
		randNumber = rand.nextInt(RoomNames.values().length);
		this.setName(RoomNames.values()[randNumber].toString());
		randNumber = rand.nextInt(2);
		if (randNumber == 1) {
			this.setIsLocked(false);
		}
		for (int i = 0; i < 4; i++) {
			randNumber = 1 + rand.nextInt(5);
			digicode += randNumber;
		}
		this.setCode(digicode);
		randNumber = rand.nextInt(3);
		this.setNbStudent(randNumber);
	}


	/**
	 *
	 * @return The code of the digicode
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "The lab " + getName() + " is locked : " + isLocked() + ", and the code is : " + code;
	}

}
