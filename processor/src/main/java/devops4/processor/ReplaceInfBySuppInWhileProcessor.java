package devops4.processor;


import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtWhile;
import spoon.reflect.declaration.CtElement;

public class ReplaceInfBySuppInWhileProcessor extends AbstractProcessor<CtElement> {

	// on place le sélecteur sur les while uniquement
	@Override
    public boolean isToBeProcessed(CtElement e) {
        return e instanceof CtWhile;
    }
	
	public void process(CtElement e) {
		// si ce n'est pas un while, on sort
		if (!(e instanceof CtWhile)) {
            return;
        }
		// on fait le cast une fois pour toutes
        CtWhile op = (CtWhile)e;
        
        // on récupère l'expression du while courant
        CtExpression<Boolean> currExp = op.getLoopingExpression();
        String s = currExp.toString();
        // on mettra ici la nouvelle expression, mutée
        String newExp = "";
        // s'il y a un <, on remplace par un >
        if (s.toString().contains("<")) {
            String[] str = s.toString().split("\\<");
            newExp = str[0] + ">" + str[1];
        }
        // s'il y a un >, on remplace par <
        else if (s.toString().contains(">")) {
            String[] str = s.toString().split("\\>");
            newExp = str[0] + "<" + str[1];
        }
        // on crée une expression avec la string modifiée
        final CtExpression<Boolean> exp = getFactory().Code().createCodeSnippetExpression(newExp);
        op.setLoopingExpression(exp); // on remplace l'expression courante par la nouvelle		
	}

}
