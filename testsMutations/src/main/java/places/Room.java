package places;

import people.Student;

/**
 * The room class
 *
 */
public abstract class Room {
	private String name;
	private boolean isLocked;
	private int nbStudent;

	/**
	 * Superconstructor
	 * 
	 * @param name
	 * @param isLocked
	 */
	public Room(String name, boolean isLocked, int nbStudent) {
		this.name = name;
		this.isLocked = isLocked;
		this.nbStudent = nbStudent;
	}

	/**
	 * The action a student can do ; it is determined by the type of the room
	 * 
	 * @param theStudent
	 */
	public abstract void action(Student theStudent);

	/**
	 * Add a student to a room
	 */
	public void addStudent() {
		nbStudent = this.getNbStudent();
		nbStudent++;
		this.setNbStudent(nbStudent);
	}

	/**
	 * Remove a student from a room
	 */
	public void removeStudent() {
		nbStudent = this.getNbStudent();
		nbStudent--;
		this.setNbStudent(nbStudent);
	}

	public abstract void enter();

	public abstract void leave();

	/**
	 * 
	 * @return The name of the student
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return true if the room is locked
	 */
	public boolean isLocked() {
		return isLocked;
	}

	/**
	 * 
	 * @param isLocked
	 */
	public void setIsLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	/**
	 * 
	 * @return the number of students in the room
	 */
	public int getNbStudent() {
		return nbStudent;
	}

	/**
	 * 
	 * @param nbStudent
	 */
	public void setNbStudent(int nbStudent) {
		this.nbStudent = nbStudent;
	}

	@Override
	public String toString() {
		return name;
	}

}
