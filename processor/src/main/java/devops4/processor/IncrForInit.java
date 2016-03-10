package devops4.processor;

import java.util.List;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtFor;
import spoon.reflect.code.CtStatement;

public class IncrForInit extends AbstractProcessor<CtFor>{

	public void process(CtFor f) {
		List<CtStatement> i = f.getForInit();
		CtStatement ini = i.get(0);
		String s = ini.toString();
		String newInit;
		if (s.contains("=")) {
			String str[] = s.split("\\=");
			newInit = str[0] + "= 1";
			CtStatement forinit = getFactory().Code().createCodeSnippetStatement(newInit);
			f.removeForInit(ini);
			f.addForInit(forinit);				
			}
	
	}
}
