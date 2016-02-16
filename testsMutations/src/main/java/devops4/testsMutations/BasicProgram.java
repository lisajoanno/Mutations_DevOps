package devops4.testsMutations;

public class BasicProgram {

	private String s;
	
	public BasicProgram() {
		s = "My basic program";
	}
	
	public boolean doNothing() {
		return true;
	}
	
	public void changeStr(String str) {
		this.s = str;
	}
	
}
