package com.demo.designPattern.pattern.interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 实现场景: 输入表达式，再输入值，求结果
 *
 * 例: a+b-c+d
 * 请输入a,b,c,d的值: 10, 5, 5, 10
 * 结果: 20
 */
abstract class Expression {
	// key: 表达式参数 例 a,b,c
	// val: 具体值
	public abstract int interpreter(Map<String, Integer> map);
}

// 运算符号解释器，每个运算符号，都只和自己左右两个数字有关系
class SymbolExpression extends Expression {
	protected Expression left;
	protected Expression right;

	public SymbolExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int interpreter(Map<String, Integer> map) {
		return 0;
	}
}

// 变量的解释器
class VarExpression extends Expression {
	private String key;

	public VarExpression(String key) {
		this.key = key;
	}

	@Override
	public int interpreter(Map<String, Integer> map) {
		return map.get(this.key);
	}
}

// 加法解释器
class AddExpression extends SymbolExpression  {

	public AddExpression(Expression left, Expression right) {
		super(left, right);
	}

	public int interpreter(Map<String, Integer> map) {
		return super.left.interpreter(map) + super.right.interpreter(map);
	}
}

// 减法解释器
class SubExpression extends SymbolExpression {

	public SubExpression(Expression left, Expression right) {
		super(left, right);
	}

	public int interpreter(Map<String, Integer> map) {
		return super.left.interpreter(map) - super.right.interpreter(map);
	}
}

class Calculator {
	private Expression expression;

	public Calculator(String expStr) {
		Stack<Expression> stack = new Stack<>();
		char[] charArray = expStr.toCharArray();

		Expression left = null;
		Expression right = null;
		for (int i = 0; i < charArray.length; i++) {
			switch (charArray[i]) {
				case '+':
					left = stack.pop();
					right = new VarExpression(String.valueOf(charArray[++i]));
					stack.push(new AddExpression(left, right));
					break;
				case '-':
					left = stack.pop();
					right = new VarExpression(String.valueOf(charArray[++i]));
					stack.push(new SubExpression(left, right));
					break;
				default:
					stack.push(new VarExpression(String.valueOf(charArray[i])));
					break;
			}
		}
		this.expression = stack.pop();
	}

	public int run(HashMap<String, Integer> var) {
		return this.expression.interpreter(var);
	}
}

public class Client {
	public static void main(String[] args) throws IOException {
		String expStr = getExpStr();
		HashMap<String, Integer> var = getValue(expStr);
		Calculator calculator = new Calculator(expStr);
		System.out.println("运算结果: " + expStr + "=" + calculator.run(var));
	}

	public static String getExpStr() throws IOException {
		System.out.println("请输入表达式: ");
		return (new BufferedReader(new InputStreamReader(System.in))).readLine();
	}

	public static HashMap<String, Integer> getValue(String expStr) throws IOException {
		HashMap<String, Integer> map = new HashMap<>();

		for (char ch : expStr.toCharArray()) {
			if (ch != '+' && ch != '-') {
				if (!map.containsKey(String.valueOf(ch))) {
					System.out.print("请输入 " + ch + " 的值:");
					String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
					map.put(String.valueOf(ch), Integer.valueOf(in));
				}
			}
		}
		return map;
	}
}
