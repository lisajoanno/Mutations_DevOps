package devops4.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.ModifierKind;

public class TurnPublicToPrivate extends AbstractProcessor<CtElement> {
	public void process(CtElement candidate) {
		if (!(candidate instanceof CtMethod<?>)) {
			return;
		}
		CtMethod method = (CtMethod)candidate;
		if (method.getSimpleName().equals("shouldBeVisible")) 
			method.setVisibility(ModifierKind.PRIVATE);
	}
}
