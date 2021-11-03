public class Main {
    public static void main(String[] args) {
        Calculator calculator = Calculator.instance.get();
        int a = calculator.plus.apply(1, 2);
        int b = calculator.minus.apply(1, 1);
        // int c = calculator.divide.apply(a, b); - здесь возникает RuntimeException: в процессе выполнения,
        // у нас переменная b = 0, что приводит к ArithmeticException - деление на нуль

        // Чтобы избежать возникновение ошибки можно:
        // 1. Использовать блок try-catch и обработать ошибку:
        try {
            int c = calculator.divide.apply(a, b);
            calculator.println.accept(c);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка! Деление на ноль");
        }
        // стоит заметить, что можно попробовать использовать try-catch в блоке кода самого лямбда-выражения,
        // но это ломает всю суть использования лямбда - лаконичность и краткость кода.

        // думаю самым рациональным способом будет использование выражения, которое учитывает нуль в делителе:
        int d = calculator.divideByZero.apply(a, b);
        calculator.println.accept(d);
    }
}