import java.util.regex.Pattern;

public class UC11ValidateTrainAndCargoRegex {

    private static final Pattern TRAIN_ID_PATTERN = Pattern.compile("TRN-\\d{4}");
    private static final Pattern CARGO_CODE_PATTERN = Pattern.compile("PET-[A-Z]{2}");

    public static boolean isValidTrainId(String trainId) {
        return TRAIN_ID_PATTERN.matcher(trainId).matches();
    }

    public static boolean isValidCargoCode(String cargoCode) {
        return CARGO_CODE_PATTERN.matcher(cargoCode).matches();
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC11: Validate Train ID & Cargo Codes (Regex)");

        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        boolean trainValid = isValidTrainId(trainId);
        boolean cargoValid = isValidCargoCode(cargoCode);

        System.out.println("Train ID " + trainId + " valid: " + trainValid);
        System.out.println("Cargo Code " + cargoCode + " valid: " + cargoValid);
    }
}
