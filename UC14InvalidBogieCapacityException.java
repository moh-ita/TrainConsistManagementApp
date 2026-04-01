public class UC14InvalidBogieCapacityException {

    static class InvalidCapacityException extends Exception {
        InvalidCapacityException(String message) {
            super(message);
        }
    }

    static class PassengerBogie {
        private final String type;
        private final int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity + " seats";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC14: Handle Invalid Bogie Capacity (Custom Exception)");

        try {
            PassengerBogie valid = new PassengerBogie("Sleeper", 72);
            System.out.println("Created: " + valid);

            PassengerBogie invalid = new PassengerBogie("AC Chair", 0);
            System.out.println("Created: " + invalid);
        } catch (InvalidCapacityException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}
