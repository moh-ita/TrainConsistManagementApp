import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    static class PassengerBogie {
        private final String type;
        private final int capacity;

        PassengerBogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        String getType() {
            return type;
        }

        int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity + " seats";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<PassengerBogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new PassengerBogie("Sleeper", 72));
        passengerBogies.add(new PassengerBogie("AC Chair", 56));
        passengerBogies.add(new PassengerBogie("First Class", 24));
        passengerBogies.add(new PassengerBogie("Double Decker", 120));

        runUC1(passengerBogies);
        runUC2(passengerBogies);
        runUC3();
        runUC4(passengerBogies);
        runUC5(passengerBogies);
        runUC6(passengerBogies);
        runUC7(passengerBogies);
        runUC8(passengerBogies);
        runUC9(passengerBogies);
        runUC10(passengerBogies);
    }

    private static void runUC1(List<PassengerBogie> bogies) {
        System.out.println("\nUC1: Initialize Train and Display Summary");
        System.out.println("Total bogies: " + bogies.size());
    }

    private static void runUC2(List<PassengerBogie> bogies) {
        System.out.println("\nUC2: Add Passenger Bogies");
        List<PassengerBogie> local = new ArrayList<>(bogies);
        local.add(new PassengerBogie("Economy", 80));
        System.out.println("After add, total bogies: " + local.size());
    }

    private static void runUC3() {
        System.out.println("\nUC3: Enforce Unique Bogie IDs (HashSet)");
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG-101");
        bogieIds.add("BG-102");
        bogieIds.add("BG-101");
        System.out.println("Unique bogie IDs count: " + bogieIds.size());
    }

    private static void runUC4(List<PassengerBogie> bogies) {
        System.out.println("\nUC4: Ordered Train Consist (LinkedList)");
        LinkedList<PassengerBogie> linked = new LinkedList<>(bogies);
        System.out.println("First bogie: " + linked.getFirst());
        System.out.println("Last bogie: " + linked.getLast());
    }

    private static void runUC5(List<PassengerBogie> bogies) {
        System.out.println("\nUC5: Ordered Unique Bogies (LinkedHashSet)");
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (PassengerBogie bogie : bogies) {
            set.add(bogie.getType());
        }
        set.add("Sleeper");
        System.out.println("Ordered unique bogie types: " + set);
    }

    private static void runUC6(List<PassengerBogie> bogies) {
        System.out.println("\nUC6: Map Bogie Type to Capacity (HashMap)");
        Map<String, Integer> map = new HashMap<>();
        for (PassengerBogie bogie : bogies) {
            map.put(bogie.getType(), bogie.getCapacity());
        }
        System.out.println("Capacity map: " + map);
    }

    private static void runUC7(List<PassengerBogie> bogies) {
        System.out.println("\nUC7: Sort Bogies by Capacity");
        List<PassengerBogie> sorted = new ArrayList<>(bogies);
        sorted.sort(Comparator.comparingInt(PassengerBogie::getCapacity));
        sorted.forEach(System.out::println);
    }

    private static void runUC8(List<PassengerBogie> bogies) {
        System.out.println("\nUC8: Filter Passenger Bogies using Stream");
        List<PassengerBogie> filtered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        filtered.forEach(System.out::println);
    }

    private static void runUC9(List<PassengerBogie> bogies) {
        System.out.println("\nUC9: Group Bogies by Type");
        Map<String, List<PassengerBogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(PassengerBogie::getType));
        grouped.forEach((k, v) -> System.out.println(k + " => " + v));
    }

    private static void runUC10(List<PassengerBogie> bogies) {
        System.out.println("\nUC10: Count Total Seats using reduce");
        int totalSeats = bogies.stream().map(PassengerBogie::getCapacity).reduce(0, Integer::sum);
        System.out.println("Total seating capacity: " + totalSeats);
    }
}
