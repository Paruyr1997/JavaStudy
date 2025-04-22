package src.test.java.Lesson_4.Задание_2;

public interface GeometricShape {
    double calculatePerimeter();
    double calculateArea();

    void setFillColor(String color);
    void setBorderColor(String color);
    String getFillColor();
    String getBorderColor();

    default void printInfo() {
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Цвет фона: " + getFillColor());
        System.out.println("Цвет границ: " + getBorderColor());
        System.out.println("------------------------");
    }
}