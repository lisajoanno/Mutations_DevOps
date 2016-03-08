package data;

/**
 * An enum of names for students of the simulation
 *
 */
public enum Names {
	Gerard("Gerard"), Jean("Jean"), Jhon("Jhon"), Philippe("Philippe"), Melanie("Melanie"), Sandro("Sandro"), Camille(
			"Camille"), Charlotte("Charlotte"), Vincent("Vincent"), Martine("Martine"), Genevieve(
					"Genevieve"), Alexandre("Alexandre"), Patrick("Patrick"), Quentin("Quentin"), Bob("Bob"), Arnaud(
							"Arnaud"), Bernard("Bernard");

	private String name = "";

	Names(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

}
