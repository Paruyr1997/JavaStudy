package Lesson_4;

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

    class Circle implements GeometricShape {
        private double radius;
        private String fillColor;
        private String borderColor;

        public Circle(double radius) {
            this.radius = radius;
            this.fillColor = "Белый";
            this.borderColor = "Чёрный";
        }

        @Override
        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public void setFillColor(String color) {
            this.fillColor = color;
        }

        @Override
        public void setBorderColor(String color) {
            this.borderColor = color;
        }

        @Override
        public String getFillColor() {
            return fillColor;
        }

        @Override
        public String getBorderColor() {
            return borderColor;
        }
    }

    class Rectangle implements GeometricShape {
        private double width;
        private double height;
        private String fillColor;
        private String borderColor;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
            this.fillColor = "Белый";
            this.borderColor = "Чёрный";
        }

        @Override
        public double calculatePerimeter() {
            return 2 * (width + height);
        }

        @Override
        public double calculateArea() {
            return width * height;
        }

        @Override
        public void setFillColor(String color) {
            this.fillColor = color;
        }

        @Override
        public void setBorderColor(String color) {
            this.borderColor = color;
        }

        @Override
        public String getFillColor() {
            return fillColor;
        }

        @Override
        public String getBorderColor() {
            return borderColor;
        }
    }

    class Triangle implements GeometricShape {
        private double sideA;
        private double sideB;
        private double sideC;
        private String fillColor;
        private String borderColor;

        public Triangle(double sideA, double sideB, double sideC) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
            this.fillColor = "Белый";
            this.borderColor = "Чёрный";
        }

        @Override
        public double calculatePerimeter() {
            return sideA + sideB + sideC;
        }

        @Override
        public double calculateArea() {
            double p = calculatePerimeter() / 2;
            return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        }

        @Override
        public void setFillColor(String color) {
            this.fillColor = color;
        }

        @Override
        public void setBorderColor(String color) {
            this.borderColor = color;
        }

        @Override
        public String getFillColor() {
            return fillColor;
        }

        @Override
        public String getBorderColor() {
            return borderColor;
        }
    }

    class Main {
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
}