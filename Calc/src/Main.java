import java.util.function.*;
public class Main {
    public static void main(String[] args) {
        // Создание экземпляра класса Calculator
        Calculator calc = Calculator.instance.get();

        // Выполнение математических операций
        int a = calc.plus.apply(1, 2); // 1 + 2 = 3
        int b = calc.minus.apply(1, 1); // 1 - 1 = 0

        // Обработка возможного исключения при делении на ноль
        try {
            int c = calc.devide.apply(a, b); // 3 / 0
            calc.println.accept(c);
        } catch (ArithmeticException e) {
            // Вывод сообщения об ошибке
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}


class Calculator {
    // Статическая переменная типа Supplier
    static Supplier<Calculator> instance = Calculator::new;

    // Переменные типа BinaryOperator для математических операций
    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> {
        // Обработка деления на ноль
        if (y == 0) {
            throw new ArithmeticException("Деление на ноль невозможно.");
        }
        return x / y;
    };

    // Переменные типа UnaryOperator
    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    // Переменная типа Predicate
    Predicate<Integer> isPositive = x -> x > 0;

    // Переменная типа Consumer
    Consumer<Integer> println = System.out::println;
}
