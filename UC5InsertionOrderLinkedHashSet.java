import java.util.LinkedHashSet;
import java.util.Set;

public class UC5InsertionOrderLinkedHashSet {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC5: Preserve Insertion Order of Bogies (LinkedHashSet)");

        Set<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");

        System.out.println("Final train formation (ordered, unique): " + formation);
    }
}
