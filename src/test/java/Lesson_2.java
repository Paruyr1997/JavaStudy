public class Lesson_2 {
    public static void main(String[] args) {
        System.out.println("Orange, Banana, Apple");

        printSumSign(10, -5);
        printColor(50);
        compareNumbers(10, 5);

        System.out.println("Сумма в диапазоне: " + isSumInRange(15, 5));

        evaluator(8);
        evaluator(-3);

        System.out.println("Число отрицательное? " + isNegative(-3));

        printGreeting("Павел");

        System.out.println("2025 високосный? " + isLeapYear(2025));

        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        invertArray(array);

        fillArray();
        arrayMultiplier();
        diagonalArray();

        int[] resultArray = createArray(10);
        System.out.print("Созданный массив: ");
        printIntArray(resultArray);
    }

    public static void printSumSign(int a, int b) {
        int c = a + b;
        if (c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor(int value) {
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean isSumInRange(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    public static void evaluator(int a) {
        if (a >= 0) {
            System.out.println(a + " Положительное");
        } else {
            System.out.println(a + " Отрицательное");
        }
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static void printGreeting(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
    }

    public static void invertArray(int[] array) {
        System.out.println("Исходный массив:");
        printIntArray(array);

        for (int i = 0; i < array.length; i++) {
            array[i] = 1 - array[i];
        }

        System.out.println("Инвертированный массив:");
        printIntArray(array);
    }

    public static void printIntArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void fillArray() {
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        System.out.println("Заполненный массив:");
        printIntArray(numbers);
    }

    public static void arrayMultiplier() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив для умножения:");
        printIntArray(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        System.out.println("Массив после умножения чисел < 6 на 2:");
        printIntArray(array);
    }

    public static void diagonalArray() {
        int[][] table = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                table[i][j] = i * 5 + j + 1;
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] createArray(int initialValue) {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}






