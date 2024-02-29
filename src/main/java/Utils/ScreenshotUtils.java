package Utils;

import DriverManager.DriverHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public abstract class ScreenshotUtils {
    static WebDriver driver = DriverHelper.getInstance().getDriver();

    public static void captureAndSaveScreenshot() {
        try {
            // Capture screenshot
            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
            byte[] screenshot = screenshotDriver.getScreenshotAs(OutputType.BYTES);

            // Create Screenshots directory if not exists
            createScreenshotsDirectory();

            // Build the screenshot file path
            String separator = File.separator;
            String projectPath = System.getProperty("user.dir");
            String screenshotFileName = projectPath + separator + "target" + separator +
                    "Screenshots" + separator + UUID.randomUUID().toString().substring(0, 10) + "_failure_screenshot.png";

            // Save the screenshot to the file
            Files.write(Paths.get(screenshotFileName), screenshot);

            System.out.println("Screenshot captured and saved to: " + screenshotFileName);
        } catch (IOException e) {
            System.err.println("IOException while capturing or saving screenshot: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Exception while capturing screenshot: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createScreenshotsDirectory() {
        // Define the Screenshots directory path
        Path screenshotsDirectoryPath = Paths.get("target", "Screenshots");

        // Create the directory if it doesn't exist
        if (Files.notExists(screenshotsDirectoryPath)) {
            try {
                Files.createDirectories(screenshotsDirectoryPath);
                System.out.println("Screenshots directory created at: " + screenshotsDirectoryPath.toAbsolutePath());
            } catch (IOException e) {
                System.err.println("IOException while creating Screenshots directory: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}