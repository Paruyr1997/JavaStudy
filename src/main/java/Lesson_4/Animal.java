package Lesson_4;

public class Animal {
    private static int totalAnimals = 0;
    private String name;

    public Animal(String name) {
        this.name = name;
        totalAnimals++;
    }

    public void run(int distance) {
    }

    public void swim(int distance) {
    }

    public static int getTotalAnimals() {
        return totalAnimals;
    }

    public String getName() {
        return name;
    }

    public static class Bowl {
        private int foodAmount;

        public Bowl(int initialFood) {
            this.foodAmount = Math.max(initialFood, 0);
        }

        public void addFood(int amount) {
            if (amount > 0) {
                foodAmount += amount;
                System.out.println("В миску добавлено " + amount + " еды. Теперь в миске " + foodAmount + " еды.");
            } else {
                System.out.println("Нельзя добавить отрицательное количество еды.");
            }
        }

        public void decreaseFood(int amount) {
            if (amount > 0 && foodAmount >= amount) {
                foodAmount -= amount;
            }
        }

        public int getFoodAmount() {
            return foodAmount;
        }
    }

    public static class Cat extends Animal {
        private static int totalCats = 0;
        private static final int MAX_RUN_DISTANCE = 200;
        private boolean isFull;

        public Cat(String name) {
            super(name);
            this.isFull = false;
            totalCats++;
        }

        @Override
        public void run(int distance) {
            if (distance <= MAX_RUN_DISTANCE) {
                System.out.println(getName() + " пробежал " + distance + " м.");
            } else {
                System.out.println(getName() + " не может пробежать больше " + MAX_RUN_DISTANCE + " м.");
            }
        }

        @Override
        public void swim(int distance) {
            System.out.println(getName() + " не умеет плавать.");
        }

        public void eat(Bowl bowl) {
            if (bowl.getFoodAmount() >= 1 && !isFull) {
                bowl.decreaseFood(1);
                isFull = true;
                System.out.println(getName() + " поел из миски.");
            } else {
                System.out.println(getName() + " не смог поесть из миски.");
            }
        }

        public boolean isFull() {
            return isFull;
        }

        public static int getTotalCats() {
            return totalCats;
        }
    }

    public static class Dog extends Animal {
        private static int totalDogs = 0;
        private static final int MAX_RUN_DISTANCE = 500;
        private static final int MAX_SWIM_DISTANCE = 10;

        public Dog(String name) {
            super(name);
            totalDogs++;
        }

        @Override
        public void run(int distance) {
            if (distance <= MAX_RUN_DISTANCE) {
                System.out.println(getName() + " пробежал " + distance + " м.");
            } else {
                System.out.println(getName() + " не может пробежать больше " + MAX_RUN_DISTANCE + " м.");
            }
        }

        @Override
        public void swim(int distance) {
            if (distance <= MAX_SWIM_DISTANCE) {
                System.out.println(getName() + " проплыл " + distance + " м.");
            } else {
                System.out.println(getName() + " не может проплыть больше " + MAX_SWIM_DISTANCE + " м.");
            }
        }

        public static int getTotalDogs() {
            return totalDogs;
        }
    }

    public static class Main {
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

            System.out.println("\nВсего животных: " + getTotalAnimals());
            System.out.println("Всего собак: " + Dog.getTotalDogs());
            System.out.println("Всего котов: " + Cat.getTotalCats());
        }
    }
}
