package Lesson_3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    private String name;
    private Date productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean isReserved;


    public Product(String name, String productionDateStr, String manufacturer,
                   String countryOfOrigin, double price, boolean isReserved) {
        this.name = name;
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            this.productionDate = format.parse(productionDateStr);
        } catch (Exception e) {
            this.productionDate = new Date(); // текущая дата при ошибке
        }
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }


    public void printInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("Товар: " + name);
        System.out.println("Дата производства: " + dateFormat.format(productionDate));
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна: " + countryOfOrigin);
        System.out.println("Цена: " + price);
        System.out.println("Бронь: " + (isReserved ? "Да" : "Нет"));
    }
}
