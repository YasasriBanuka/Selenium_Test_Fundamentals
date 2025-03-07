import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// Open web application
public class AddCategory_Test {
    WebDriver driver;
    @BeforeMethod
    public void setup()  { // Renamed for clarity
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:5173/");
    }
        @Test
        public void addCategory() throws InterruptedException {
            Thread.sleep(3000);
            driver.findElement(By.id("login")).click();
            // Automate login form
            WebElement userName = driver.findElement(By.id("userName"));
            userName.sendKeys("pasan");

            WebElement passwordField = driver.findElement(By.id("passWord"));
            passwordField.sendKeys("123");

            // Validate login function
            driver.findElement(By.id("login")).click();

            // Navigate to the category dashboard
            Thread.sleep(3000);
            driver.findElement(By.id("addCategory")).click();

            Thread.sleep(3000);
            driver.findElement(By.id("AddCategory")).click();

            Thread.sleep(3000);
            driver.findElement(By.id("categoryName")).click();
            WebElement cName = driver.findElement(By.id("categoryName"));
            cName.sendKeys("Mercedes-Benz");

            Thread.sleep(3000);
            driver.findElement(By.id("PriceRange")).click();
            WebElement KmPrice = driver.findElement(By.id("PriceRange"));
            KmPrice.sendKeys("600");


            WebElement addButton =  driver.findElement(By.xpath("//button[@id='addCategory']"));
            addButton.click();
            
        }
}

