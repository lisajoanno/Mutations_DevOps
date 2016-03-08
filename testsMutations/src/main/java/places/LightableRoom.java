package places;

import people.Student;

/**
 * The lightable room class
 *
 */
public abstract class LightableRoom extends Room {

	private boolean light;
	private boolean haveAnObject;

	/**
	 * The constructor of the class ; we can find objects in that type of rooms
	 * 
	 * @param name
	 * @param light
	 * 
	 */
	public LightableRoom(String name, boolean isLocked, boolean light, boolean haveAnObject, int nbStudent) {
		super(name, isLocked, nbStudent);
		this.light = light;
		this.haveAnObject = haveAnObject;
	}

	public abstract void search(Student theStudent);

	/**
	 * A student can switch on/off a lightable room, it depend if the room is
	 * already lit or not
	 * 
	 */
	public void action(Student theStudent) {
		if (this.isLocked()) {
			if (!(theStudent.isHaveKey())) {
				System.out.println("The student doesn't have the key. He can't enter in the room.");
			} else {
				this.enter();
				System.out.println("The student is in the " + this.getName());
			}
		} else {
			this.enter();
			System.out.println("The student is in the " + this.getName());
		}
	}

	public void enter() {
		if (this.getNbStudent() == 0) {
			this.setLight(true); // the first student turn on the light
		}
		this.addStudent();
		this.setIsLocked(false); // the first student open the door if he can
	}

	public void leave() {
		this.removeStudent();
		if (this.getNbStudent() == 0) {
			this.setIsLocked(true);
			this.setLight(false);
			System.out.println("The student switch off the ligth.");
			// the last student lock the room and turn off the light
		}

	}

	// getter & setter method

	/**
	 * 
	 * @return true if the room is already lit
	 */
	public boolean isLight() {
		return light;
	}

	/**
	 * 
	 * @param light
	 */
	public void setLight(boolean light) {
		this.light = light;
	}

	/**
	 * 
	 * @return true if there is an object in the room
	 */
	public boolean isHaveAnObject() {
		return haveAnObject;
	}

	/**
	 * 
	 * @param haveAnObject
	 */
	public void setHaveAnObject(boolean haveAnObject) {
		this.haveAnObject = haveAnObject;
	}

}
