package devops4.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtWhile;

public class BreakInWhile extends AbstractProcessor<CtWhile> {

	/**
	 * Ajouter un break dans un while
	 */
	public void process(CtWhile candidate) {
		CtCodeSnippetStatement br = getFactory().Code().createCodeSnippetStatement("break");
		candidate.setBody(br);
	}

}
