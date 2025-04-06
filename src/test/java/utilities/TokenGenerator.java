package utilities;

import java.io.*;

public class TokenGenerator {

    private static final String COUNTER_FILE = "token_counter.txt";

    public static String getNextToken() {
        int counter = readCounter();
        saveCounter(counter + 1);
        return String.valueOf(counter);
    }

    private static int readCounter() {
        try (BufferedReader reader = new BufferedReader(new FileReader(COUNTER_FILE))) {
            return Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            // If file doesn't exist or has invalid content, start from 1
            return 1;
        }
    }

    private static void saveCounter(int newCounter) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(COUNTER_FILE))) {
            writer.write(String.valueOf(newCounter));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
