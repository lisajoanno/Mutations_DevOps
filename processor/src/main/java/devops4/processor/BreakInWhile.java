package devops4.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtWhile;

public class BreakInWhile extends AbstractProcessor<CtWhile> {

	/**
	 * Ajouter un break dans un while
	 */
	public void process(CtWhile candidate) {
		// on récupère le body du while sous forme de CtStatement
		CtStatement b = candidate.getBody();
		// on crée un snippet pour contenir le break
		CtCodeSnippetStatement br = getFactory().Code().createCodeSnippetStatement("break");
		// on crée un bloc pour contenir tous les statements
		CtBlock<?> bl = getFactory().Core().createBlock();
		bl.addStatement(b);
		bl.addStatement(br);
		
		// on met le nouveau body dans le while courant, après avoir ajouté le break
		candidate.setBody(bl);
	}

}
