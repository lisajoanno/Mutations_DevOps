package people;

public class Person {
	private String name;

	/**
	 * Superconstructor
	 * 
	 * @param name
	 */
	public Person(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The name of the person
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

	@Override
	public String toString() {
		return name;
	}

}
