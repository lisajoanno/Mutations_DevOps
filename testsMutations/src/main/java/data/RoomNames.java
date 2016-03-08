package data;

/**
 * An enum of rooms names (like classrooms and labs)
 *
 */
public enum RoomNames {
	SVT("svt"), PC("physical-chemistry"), MATH("math"), EG("english"), IC("computer");

	private String name = "";

	RoomNames(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
