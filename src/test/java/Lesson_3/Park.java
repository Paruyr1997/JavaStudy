package Lesson_3;

public class Park {

    private String parkName;
    private Attraction[] attractions;


    public class Attraction {
        private String name;
        private String workingHours;
        private double price;

        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getWorkingHours() {
            return workingHours;
        }

        public double getPrice() {
            return price;
        }

        public void displayInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + price + " руб.");
        }
    }


    public Park(String parkName, Attraction[] attractions) {
        this.parkName = parkName;
        this.attractions = attractions;
    }


    public void displayParkInfo() {
        System.out.println("Парк: " + parkName);
        System.out.println("Аттракционы:");
        for (Attraction attraction : attractions) {
            attraction.displayInfo();
            System.out.println("------------------");
        }
    }


    public static void main(String[] args) {
        Park.Attraction[] attractions = new Park.Attraction[3];
        Park disneyland = new Park("Disneyland", null);

        attractions[0] = disneyland.new Attraction("Space Mountain", "10:00-22:00", 250.0);
        attractions[1] = disneyland.new Attraction("Pirates of Caribbean", "09:00-20:00", 150.0);
        attractions[2] = disneyland.new Attraction("Haunted Mansion", "11:00-19:00", 120.);

        disneyland.attractions = attractions;
        disneyland.displayParkInfo();

    }
}

