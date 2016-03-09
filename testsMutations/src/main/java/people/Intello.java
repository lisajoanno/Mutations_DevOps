package people;

public class Intello extends Person {

	private String knowledge;

	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public Intello(String name) {
		super(name);
	}

	public Intello(String name, String knowledge) {
		super(name);
		this.setKnowledge(knowledge);
	}

	public String getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(String knowledge) {
		this.knowledge = knowledge;
	}

	@Override
	public String toString() {
		return "I am an intello";
	}

}
