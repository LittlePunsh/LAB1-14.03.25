import java.util.Scanner;

// Антипаттерн: "God Object" - один класс делает всё
// Класс выполняет логику, хранит данные и управляет вводом-выводом
class FactorialCalculator {
    public int input;
    public String result;

    // Антипаттерн: "Magic Numbers" - непонятные числа в коде
    // 100 - бессмысленный предел ввода
    public void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        input = scanner.nextInt();
        if (input < 0 || input > 100) {
            System.out.println("Ошибка!");
            System.exit(0); // Антипаттерн: "Spaghetti Code" - неожиданный выход
        }
    }

    // Антипаттерн: "Reinventing the Wheel" - реализуем свою версию уже существующего решения
    public void calculateFactorial() {
        int fact = 1;
        for (int i = 1; i <= input; i++) {
            fact *= i;
        }
        result = "Факториал: " + fact; // Антипаттерн: "String Concatenation in Loop"
    }

    // Антипаттерн: "Lava Flow" - ненужный закомментированный код
    // public void unusedMethod() { System.out.println("Этот метод не нужен"); }
}

// Антипаттерн: "Big Ball of Mud" - беспорядочная архитектура
// Этот класс делает практически ничего, кроме вызова методов другого класса
class App {
    static FactorialCalculator fc = new FactorialCalculator();

    // Антипаттерн: "Hardcoded Configuration" - определенные значения
    static int defaultNumber = 7;

    public static void main(String[] args) {
        if (args.length > 0) {
            fc.input = Integer.parseInt(args[0]); // Антипаттерн: "Input Kludge" - не проверяем ввод
        } else {
            fc.input = defaultNumber; // Антипаттерн: "Hardcoded Configuration"
        }

        fc.calculateFactorial();
        System.out.println(fc.result);

        // Антипаттерн: "Dead Code" - бесполезный вызов метода
        new App().unusedMethod();
    }

    public void unusedMethod() {
        // Этот метод никогда не вызывается осмысленно
    }
}
