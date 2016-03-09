package devops4.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.declaration.CtElement;

/** a trivial mutation operator that transforms all binary operators to minus ("-") */
public class BinaryOperatorMutator extends AbstractProcessor<CtElement> {
	@Override
	public boolean isToBeProcessed(CtElement candidate) {
		if (candidate instanceof CtBinaryOperator) {
			CtBinaryOperator op = (CtBinaryOperator) candidate;
			if (op.getLeftHandOperand().getClass().getName().equals("java.lang.Integer")
				&&
				op.getRightHandOperand().getClass().getName().equals("java.lang.Integer")) {
				return op.getKind() == BinaryOperatorKind.PLUS;
			}
		}
		return false;
	}
	
	public void process(CtElement candidate) {
		CtBinaryOperator op = (CtBinaryOperator) candidate;
		op.setKind(BinaryOperatorKind.MINUS);
	}
}
