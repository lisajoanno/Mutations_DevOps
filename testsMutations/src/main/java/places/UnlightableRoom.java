package places;

import people.Student;

/**
 * A class for unlightable rooms
 * 
 */
public abstract class UnlightableRoom extends Room {

	public UnlightableRoom(String name, boolean isLocked, int nbStudent) {
		super(name, isLocked, nbStudent);
	}

	public abstract void action(Student theStudent);

	public void enter() {
		this.addStudent();
		this.setIsLocked(false);
	}

	public void leave() {
		this.removeStudent();
		if (this.getNbStudent() == 0) {
			this.setIsLocked(true);
		}
	}

}
