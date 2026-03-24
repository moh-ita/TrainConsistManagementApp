import java.util.ArrayList;
import java.util.List;

public class UC2PassengerBogiesArrayList {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC2: Add Passenger Bogies to Train (ArrayList Operations)");

        List<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("After adding bogies: " + passengerBogies);

        passengerBogies.remove("AC Chair");
        System.out.println("After removing AC Chair: " + passengerBogies);

        boolean sleeperExists = passengerBogies.contains("Sleeper");
        System.out.println("Does Sleeper exist? " + sleeperExists);

        System.out.println("Final passenger bogie list: " + passengerBogies);
    }
}
