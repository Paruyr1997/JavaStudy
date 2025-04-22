package src.test.java.Lesson_4.Задание_2;

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);
        Triangle triangle = new Triangle(3, 4, 5);

        circle.setFillColor("Красный");
        circle.setBorderColor("Золотой");

        rectangle.setFillColor("Синий");
        rectangle.setBorderColor("Белый");

        triangle.setFillColor("Зелёный");
        triangle.setBorderColor("Чёрный");

        System.out.println("Круг:");
        circle.printInfo();

        System.out.println("Прямоугольник:");
        rectangle.printInfo();

        System.out.println("Треугольник:");
        triangle.printInfo();
    }
}
