package devops4.processor;

import java.util.Set;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtConstructor;

/**
 * Processeur qui supprime les constructeurs d'une classe.
 *
 */
public class DeleteConstructor extends AbstractProcessor<CtClass<?>> {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void process(CtClass candidate) {
		Set<CtConstructor> construct = candidate.getConstructors();
		for (CtConstructor c : construct) {
			candidate.removeConstructor(c);
		}
	}
}
