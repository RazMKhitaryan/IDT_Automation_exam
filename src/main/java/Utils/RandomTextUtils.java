package Utils;

import java.util.Random;


public abstract class RandomTextUtils {
    public static String generateRandomText() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomText = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            randomText.append(randomChar);
        }

        return randomText.toString();
    }

    public static int generateRandomNumber(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Invalid range. Min value should be less than or equal to max value.");
        }

        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }


    public static String generateRandomMonth() {
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        Random random = new Random();
        int randomIndex = random.nextInt(months.length);
        return months[randomIndex];
    }

    public static String generateRandomCountry() {
        String[] countries = {
                "India", "United States", "Canada", "Australia",
                "New Zealand", "Singapore", "Israel"
        };

        Random random = new Random();
        int randomIndex = random.nextInt(countries.length);
        return countries[randomIndex];
    }

}
