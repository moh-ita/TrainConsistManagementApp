import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UC13LoopVsStreamPerformance {

    static class Bogie {
        private final String type;
        private final int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity;
        }
    }

    private static List<Bogie> filterWithLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.getCapacity() > 60) {
                result.add(bogie);
            }
        }
        return result;
    }

    private static List<Bogie> filterWithStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC13: Performance Comparison (Loops vs Streams)");

        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Bogie-" + i, 20 + (i % 120)));
        }

        long loopStart = System.nanoTime();
        List<Bogie> loopFiltered = filterWithLoop(bogies);
        long loopEnd = System.nanoTime();

        long streamStart = System.nanoTime();
        List<Bogie> streamFiltered = filterWithStream(bogies);
        long streamEnd = System.nanoTime();

        long loopElapsed = loopEnd - loopStart;
        long streamElapsed = streamEnd - streamStart;

        System.out.println("Loop filtered count: " + loopFiltered.size());
        System.out.println("Stream filtered count: " + streamFiltered.size());
        System.out.println("Loop execution time (ns): " + loopElapsed);
        System.out.println("Stream execution time (ns): " + streamElapsed);
    }
}
