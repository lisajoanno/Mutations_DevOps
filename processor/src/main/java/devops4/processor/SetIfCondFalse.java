package devops4.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;

public class SetIfCondFalse extends AbstractProcessor<CtIf> {
	public void process(CtIf i) {
		// on crée une expression avec la string modifiée
		final CtExpression<Boolean> exp = getFactory().Code()
				.createCodeSnippetExpression("false");
		i.setCondition(exp); // on remplace l'expression courante par
								// la nouvelle
	}

}
