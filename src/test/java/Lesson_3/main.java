package Lesson_3;

public class main {
    public static void main(String[] args) {

        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 15 Pro", "15.09.2023",
                "Apple Inc.", "USA", 1299, false);
        productsArray[2] = new Product("Xiaomi Mi 13", "20.11.2022",
                "Xiaomi Corporation", "China", 799, true);
        productsArray[3] = new Product("Galaxy Watch 5", "10.08.2022",
                "Samsung Corp.", "Korea", 299, false);
        productsArray[4] = new Product("MacBook Pro 16", "01.01.2024",
                "Apple Inc.", "USA", 2499, true);

        for (Product product : productsArray) {
            product.printInfo();
        }
    }
}

