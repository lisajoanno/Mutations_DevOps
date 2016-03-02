package devops4.testsMutations;


public class BasicProgram {
    private java.lang.String s;

    public BasicProgram() {
        s = "My basic program";
    }

    public boolean doNothing() {
        return true;
    }

    public void changeStr(java.lang.String str) {
        this.s = str;
    }
}

