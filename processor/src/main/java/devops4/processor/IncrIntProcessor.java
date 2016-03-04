package devops4.processor;


import java.util.Arrays;

import static java.lang.System.out;

import java.util.Collection;

import org.eclipse.jdt.core.dom.Initializer;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtAssignment;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtFieldWrite;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.reference.CtFieldReference;
import spoon.reflect.reference.CtTypeReference;

public class IncrIntProcessor extends AbstractProcessor<CtClass<?>> {

	public void process(CtClass<?> currentClass) {
		
		CtExpression<Integer> exp = getFactory().Code()
				.createCodeSnippetExpression("2");
		
		CtField<?> one = currentClass.getField("one");
		one.getAssignment().replace(exp);

	}

}
