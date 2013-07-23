package com.example;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.example.model.User;

@ContextConfiguration("classpath:beans.xml")
public class SpELTest extends AbstractJUnit4SpringContextTests {

//	@Test
	public void test01() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("'Hello, world!'");
		System.out.println((String) expression.getValue());
	}
	
	@Test
	public void test02() {
		User user = new User();
		user.setUsername("bob");
		user.setPassword("bob");
		
		EvaluationContext ec = new StandardEvaluationContext(user);
		
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("username"); // i.e. user.getUsername
		System.out.println((String)expression.getValue(ec));
		System.out.println((String)expression.getValue(user));
	}
}
