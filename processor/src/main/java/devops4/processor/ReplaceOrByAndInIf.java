package devops4.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;

public class ReplaceOrByAndInIf extends AbstractProcessor<CtIf> {
	public void process(CtIf i) {
		// on récupère l'expression du if courant
		CtExpression<Boolean> currExp = i.getCondition();
		String s = currExp.toString();
		// on mettra ici la nouvelle expression, mutée
		String newExp = "";

		// s'il y a un &&, on remplace par un ||
		if (s.toString().contains("&&")) {
			String[] str = s.toString().split("\\&");
			newExp = str[0] + "||" + str[2];
		}
		// s'il y a un ||, on remplace par &&
		else if (s.toString().contains("")) {
			String[] str = s.toString().split("\\|");
			newExp = str[0] + "&&" + str[2];
		}
		// on crée une expression avec la string modifiée
		final CtExpression<Boolean> exp = getFactory().Code()
				.createCodeSnippetExpression(newExp);
		i.setCondition(exp); // on remplace l'expression courante par
								// la nouvelle
	}

}
