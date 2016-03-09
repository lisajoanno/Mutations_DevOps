package devops4.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.ModifierKind;

public class DeleteConstructor extends AbstractProcessor<CtClass<?>> {

	public void process(CtClass<?> ctClass) {

		final CtField<String> s = getFactory().Core().<String> createField();

		final CtCodeSnippetStatement statementInConstructor = getFactory().Code().createCodeSnippetStatement("");
		final CtBlock<?> ctBlockOfConstructor = getFactory().Code().createCtBlock(statementInConstructor);
		final CtConstructor constructor = getFactory().Core().createConstructor();
		constructor.setBody(ctBlockOfConstructor);
		constructor.addModifier(ModifierKind.PUBLIC);
		// Apply transformation.
		ctClass.addField(s);
		ctClass.addConstructor(constructor);
	}

}
