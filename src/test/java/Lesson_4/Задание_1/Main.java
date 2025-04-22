package src.test.java.Lesson_4.Задание_1;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шарик");
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Барсик");
        Cat cat3 = new Cat("Васька");

        dog1.run(300);
        dog1.run(600);
        dog1.swim(5);
        dog1.swim(15);

        cat1.run(100);
        cat1.run(250);
        cat1.swim(1);

        Bowl bowl = new Bowl(2); // Миска с 2 единицами еды
        Cat[] cats = {cat1, cat2, cat3};

        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сытость: " + cat.isFull());
        }

        bowl.addFood(3);
        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eat(bowl);
            }
        }

        System.out.println("\nВсего животных: " + Animal.getTotalAnimals());
        System.out.println("Всего собак: " + Dog.getTotalDogs());
        System.out.println("Всего котов: " + Cat.getTotalCats());
    }
}
