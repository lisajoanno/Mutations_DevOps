package devops4.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.ModifierKind;

/**
 * Processeur pour changer l'accessibilité d'une variable dans une classe en
 * 'protected'.
 * 
 * @Selector On applique ce processeur uniquement pour les variables globales,
 *           les variables des classes ne sont pas affectées.
 *
 */
public class ChangeVarAccessibility extends AbstractProcessor<CtClass<?>> {

	public boolean isToBeProcessed(CtClass<?> candidate) {
		if (!(candidate instanceof CtMethod)) {
			return true;
		}
		return false;
	}

	public void process(CtClass<?> candidate) {
		if (candidate instanceof CtField<?>) {
			return;
		}

		candidate.setVisibility(ModifierKind.PROTECTED);
	}

}
