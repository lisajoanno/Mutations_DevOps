package data;

/**
 * An enum of corridors names
 *
 */
public enum CorridorNames {
	M("main corridor"), S("sud corridor"), E("east corridor"), W(
			"west corridor"), N("north corridor"), SMALL("small corridor"), LAR(
			"large corridor");

	private String name = "";

	CorridorNames(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
