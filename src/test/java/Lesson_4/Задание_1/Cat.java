package src.test.java.Lesson_4.Задание_1;

public class Cat extends Animal {
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
