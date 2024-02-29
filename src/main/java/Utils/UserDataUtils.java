package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserDataUtils {

    public static void writeUserDataInFile(String username, String email, String password) {
        // Define the path for the logs folder
        Path logsDirectoryPath = Paths.get("logs");

        // Create the directory if it doesn't exist
        if (Files.notExists(logsDirectoryPath)) {
            try {
                Files.createDirectories(logsDirectoryPath);
                System.out.println("Logs directory created at: " + logsDirectoryPath.toAbsolutePath());
            } catch (IOException e) {
                System.err.println("IOException while creating Logs directory: " + e.getMessage());
                e.printStackTrace();
            }
        }

        // Define the path for the userData file in the logs folder
        Path userDataFilePath = logsDirectoryPath.resolve("userData.txt");

        // Create the file if it doesn't exist
        if (Files.notExists(userDataFilePath)) {
            try {
                Files.createFile(userDataFilePath);
                System.out.println("userData.txt file created at: " + userDataFilePath.toAbsolutePath());
            } catch (IOException e) {
                System.err.println("IOException while creating userData.txt file: " + e.getMessage());
                e.printStackTrace();
            }
        }

        // Write user data to the userData file with append
        try (FileWriter writer = new FileWriter(userDataFilePath.toString(), false)) {
            // Example strings to write
            String userData = "User: " + username + "\n"
                    + "Email: " + email + "\n"
                    + "Password: " + password + "\n";

            // Append user data to the file
            writer.write(userData);

        } catch (IOException e) {
            System.err.println("IOException while writing to userData.txt file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String readUserDataFromFile() {
        // Define the path for the userData file in the logs folder
        Path userDataFilePath = Paths.get("logs", "userData.txt");

        // Read user data from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(userDataFilePath.toFile()))) {
            String username = reader.readLine().split(":")[1].trim();
            String email = reader.readLine().split(":")[1].trim();
            String password = reader.readLine().split(":")[1].trim();

            // Concatenate the information into a single string
            return username + " " + email + " " + password;
        } catch (IOException e) {
            System.err.println("IOException while reading userData.txt file: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


}