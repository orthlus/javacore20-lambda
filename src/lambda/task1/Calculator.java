package lambda.task1;

import java.util.function.*;

public class Calculator {
	static Supplier<Calculator> instance = Calculator::new;
	BinaryOperator<Integer> plus = (x, y) -> x + y;
	BinaryOperator<Integer> minus = (x, y) -> x - y;
	BinaryOperator<Integer> multiply = (x, y) -> x * y;
	BinaryOperator<Integer> divide = (x, y) -> x / y;
	UnaryOperator<Integer> pow = x -> x * x;
	UnaryOperator<Integer> abs = x -> x > 0 ? x:-x;
	Predicate<Integer> isPositive = x -> x > 0;
	Consumer<Integer> println = System.out::println;

	public static void main(String[] args) {
		Calculator calc = Calculator.instance.get();
		int a = calc.plus.apply(1, 2);
		int b = calc.minus.apply(1, 1);
		// ошибка деления на 0, решение - не делить на 0
		// int c = calc.divide.apply(a, b);
		b = calc.plus.apply(b, 1);
		int c = calc.divide.apply(a, b);
		calc.println.accept(c);
	}
}
