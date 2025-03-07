import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Cus_ProfileValidation_Test {


    WebDriver driver;

    @BeforeMethod
    public void setup() { // Renamed for clarity
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:5173/");
    }

    @Test
    public  void updateProfile () throws InterruptedException {

        Thread.sleep(3000);
        driver.findElement(By.id("login")).click();
        // Automate login form
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("milan");

        WebElement passwordField = driver.findElement(By.id("passWord"));
        passwordField.sendKeys("milan11");

        // Validate login function
        driver.findElement(By.id("login")).click();

        Thread.sleep(3000);
        for (String s : Arrays.asList("customerProfile", "customerPro", "customerEdit")) {
            driver.findElement(By.id(s)).click();

            Thread.sleep(3000);
        }

        driver.findElement(By.id("customerName")).clear();
        driver.findElement(By.id("customerName")).sendKeys("Pasindu Sampath");

        driver.findElement(By.id("customerEmail")).clear();
        driver.findElement(By.id("customerEmail")).sendKeys("banuka12@gmail");

        driver.findElement(By.id("customerPhone")).clear();
        driver.findElement(By.id("customerPhone")).sendKeys("0113323");

        driver.findElement(By.id("CustomerAddress")).clear();
        driver.findElement(By.id("CustomerAddress")).sendKeys("Park Road , Colombo");

        Thread.sleep(3000);
        driver.findElement(By.id("update")).click();
    }
}
