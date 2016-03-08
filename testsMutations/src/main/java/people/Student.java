package people;

/**
 * A class for students
 *
 */
public class Student extends Person {

	private boolean haveKey;
	private boolean haveDigicode;

	/**
	 * The constructor of the class Students have a name, can have a key and/or
	 * a digicode solution
	 * 
	 * @param string
	 * @param haveKey
	 * @param haveDigicode
	 */
	public Student(String string, boolean haveKey, boolean haveDigicode) {
		super(string);
		this.haveKey = haveKey;
		this.haveDigicode = haveDigicode;
	}

	public Intello turnIntoIntello() {
		Intello intello = new Intello(this.getName());
		return intello;
	}

	/**
	 * 
	 * @return true if the student have a key
	 */
	public boolean isHaveKey() {
		return haveKey;
	}

	/**
	 * 
	 * @param haveKey
	 */
	public void setHaveKey(boolean haveKey) {
		this.haveKey = haveKey;
	}

	/**
	 * 
	 * @return true if the student have the digicode combination
	 */
	public boolean isHaveDigicode() {
		return haveDigicode;
	}

	/**
	 * 
	 * @param haveDigicode
	 */
	public void setHaveDigicode(boolean haveDigicode) {
		this.haveDigicode = haveDigicode;
	}

	@Override
	public String toString() {
		return "Student " + getName() + " have the key : " + haveKey + ", have the digicode : " + haveDigicode;
	}
}
