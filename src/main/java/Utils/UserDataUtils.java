package Utils;

import Helpers.UserObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserDataUtils {

    public static void writeUserDataInFile(String username, String email, String password, String gender,
                                           String firstName, String lastName, String company, String address,
                                           String address2, String city, String state, String zipcode,
                                           String country, String mobileNumber) {
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

        // Example strings to write
        String userData = "User: " + username + "\n"
                + "Email: " + email + "\n"
                + "Password: " + password + "\n"
                + "Gender: " + gender + "\n"
                + "First Name: " + firstName + "\n"
                + "Last Name: " + lastName + "\n"
                + "Company: " + company + "\n"
                + "Address: " + address + "\n"
                + "Address 2: " + address2 + "\n"
                + "City: " + city + "\n"
                + "State: " + state + "\n"
                + "Zipcode: " + zipcode + "\n"
                + "Country: " + country + "\n"
                + "Mobile Number: " + mobileNumber + "\n";

        // Append user data to the file
        try (FileWriter writer = new FileWriter(userDataFilePath.toString(), false)) {
            writer.write(userData);

        } catch (IOException e) {
            System.err.println("IOException while writing to userData.txt file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static UserObject readUserDataFromFile() {
        // Define the path for the userData file in the logs folder
        Path userDataFilePath = Paths.get("logs", "userData.txt");

        // Read user data from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(userDataFilePath.toFile()))) {
            String username = reader.readLine().split(":")[1].trim();
            String email = reader.readLine().split(":")[1].trim();
            String password = reader.readLine().split(":")[1].trim();
            String address = reader.readLine().split(":")[1].trim();
            String gender = reader.readLine().split(":")[1].trim();
            String firstName = reader.readLine().split(":")[1].trim();
            String lastName = reader.readLine().split(":")[1].trim();
            String company = reader.readLine().split(":")[1].trim();
            String address2 = reader.readLine().split(":")[1].trim();
            String city = reader.readLine().split(":")[1].trim();
            String state = reader.readLine().split(":")[1].trim();
            String zipcode = reader.readLine().split(":")[1].trim();
            String country = reader.readLine().split(":")[1].trim();
            String mobileNumber = reader.readLine().split(":")[1].trim();

            // Concatenate the information into a single string
            return new UserObject(username, email, password, gender, firstName, lastName, company, address, address2, city, state, zipcode, country, mobileNumber);
        } catch (IOException e) {
            System.err.println("IOException while reading userData.txt file: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}