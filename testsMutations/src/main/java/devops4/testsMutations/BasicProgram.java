package devops4.testsMutations;


public class BasicProgram {
    private java.lang.String s;

    private boolean b = true;

    public BasicProgram() {
    	try {
    		
    	} catch (Exception e) {};
        s = "My basic program";
    }

    public boolean doNothing() {
        return true;
    }

    public void changeStr(java.lang.String str) {
        this.s = str;
    }
    
    public int shouldReturn2() {
    	return 1+1;
    }
    
    public String shouldBeVisible() {
    	return "I am public";
    }
    
    public int whileIncrement() {
    	int i = 0;
    	
    	while (i < 10)
    		i++;
    	return i;
    }
}

