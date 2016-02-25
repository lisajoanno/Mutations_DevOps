package devops4.testsMutations;


public class MutBasicProgram {
    private java.lang.String s;

    public MutBasicProgram() {
        s = "My basic program";
    }

    public boolean doNothing() {
        return true;
    }

    public void changeStr(java.lang.String str) {
        this.s = str;
    }

    public MutBasicProgram(java.util.List<java.util.Date> dates) {
        this.dates = dates;
    }

    private java.util.List<java.util.Date> dates;
}

