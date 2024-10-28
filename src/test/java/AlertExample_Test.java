import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample_Test {
    WebDriver driver;// use for all methods

    @BeforeMethod
    public void AlertTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }
    @Test
    public  void AlertTest() throws InterruptedException {

        // 1) Alert (Simple Alert)
       WebElement alertSimple = driver.findElement(By.id("j_idt88:j_idt91"));
       alertSimple.click();
       Thread.sleep(3000);
       Alert alert = driver.switchTo().alert();
       alert.accept();

        // 2) Alert (Confirm Alert)
        WebElement alertConfirm = driver.findElement(By.id("j_idt88:j_idt93"));
        alertConfirm.click();
        Thread.sleep(3000);
        Alert Dis = driver.switchTo().alert();
        Dis.dismiss();

        // 3) Alert (Prompt Alert)
        WebElement promt = driver.findElement(By.id("j_idt88:j_idt104"));
        promt.click();
        Thread.sleep(3000);
        Alert al =driver.switchTo().alert();
        String alt =  al.getText();
        System.out.print("Alert test is :" + alt);
        al.sendKeys(" Selenium test is success");
        al.accept();

    }

}
