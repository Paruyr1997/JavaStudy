package src.test.java.Lesson_5;

public class ArraySumCalculator {
    public static int sumArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4x4, но получен " + array.length + "xN");
        }

        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException("Массив должен быть размером 4x4, но получена строка длиной " + row.length);
            }
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: '" + array[i][j] + "'");
                }
            }
        }

        return sum;
    }

    public static void generateArrayIndexOutOfBoundsException() {
        int[] arr = new int[5];
        int value = arr[10];
    }
}
