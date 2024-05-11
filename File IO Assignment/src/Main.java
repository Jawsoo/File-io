import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Set your directory or use current working directory
        String projectDirectory = System.getProperty("user.dir");

        // Define file path
        String filePath = projectDirectory + File.separator + "example.txt";

        // Create the file if not exists and add names only if created during this run
        if (createFileIfNotExists(filePath)) {
            // Add 5 names to the text file
            addNamesToFile(filePath, new String[]{"Josue", "Anthony", "Racheal", "Santiago", "Coco"});
        }

        // Read and print names from the file
        readAndPrintNames(filePath);
    }

    private static boolean createFileIfNotExists(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File '" + filePath + "' created successfully.");
                    return true;
                }
            } catch (IOException e) {
                System.err.println("Error creating file: " + e.getMessage());
            }
        } else {
            System.out.println("File '" + filePath + "' already exists. Skipping creation.");
        }
        return false;
    }

    private static void addNamesToFile(String filePath, String[] names) {
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            for (String name : names) {
                fileWriter.write(name + "\n");
            }
            System.out.println("Names added to the file.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void readAndPrintNames(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Names in the file:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}
