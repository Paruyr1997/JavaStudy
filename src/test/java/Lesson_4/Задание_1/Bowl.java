package src.test.java.Lesson_4.Задание_1;

public class Bowl {
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