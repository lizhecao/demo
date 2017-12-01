package com.test.demo.spring;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Created by lizhecao on 2017-9-1.
 */
public class SpelTest {

  public static void main(String[] args) {
    ExpressionParser parser = new SpelExpressionParser();
    EvaluationContext ctx = new StandardEvaluationContext();

    ctx.setVariable("name", "ryan");
    ctx.setVariable("age", 27);

    System.out.println(parser.parseExpression("'hi'' '+#name+' 0 age is '+#age").getValue(ctx, String.class));
  }
}
