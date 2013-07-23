package com.example;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration("classpath:beans.xml")
public class SpELTest extends AbstractJUnit4SpringContextTests {

	@Test
	public void test01() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("'Hello, world!'");
		System.out.println((String) expression.getValue());
	}
}
