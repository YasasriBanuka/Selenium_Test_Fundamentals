import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

    public class OpenGoogle_Test {

        @Test
        public void googleTest(){
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com/");

            // Finding the web element and interacting with LOCATORS

            // name locators
            //Keys.ENTER this part is when selenium type colombo the automatically  click eneter and open the page
            driver.findElement(By.name("q")).sendKeys("cardiff moodle" + Keys.ENTER );

            //driver.quit();
        }
    }

