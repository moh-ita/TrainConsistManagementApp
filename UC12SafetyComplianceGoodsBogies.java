import java.util.ArrayList;
import java.util.List;

public class UC12SafetyComplianceGoodsBogies {

    static class GoodsBogie {
        private final String type;
        private final String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() {
            return type;
        }

        public String getCargo() {
            return cargo;
        }

        @Override
        public String toString() {
            return type + " -> " + cargo;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC12: Safety Compliance Check for Goods Bogies");

        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Rectangular", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));

        boolean isSafe = goodsBogies.stream()
                .allMatch(b -> !"Cylindrical".equalsIgnoreCase(b.getType())
                        || "Petroleum".equalsIgnoreCase(b.getCargo()));

        System.out.println("Goods bogies: " + goodsBogies);
        System.out.println("Train safety compliant: " + isSafe);
    }
}
