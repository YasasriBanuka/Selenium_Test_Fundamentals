import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample_Test {

    WebDriver driver;// use for all methods


    //check before running the test

    @BeforeMethod
    public void openLinkTestPage() {
        driver = new ChromeDriver();
        //fixed browser pc screen size
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void LinkTest() {
        // 01) Check Take me to Dashboard
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back(); // forward(); refresh();

        // 02) Check Find my destination

        WebElement wheretoGo = driver.findElement(By.partialLinkText("Find the URL"));
        String path = wheretoGo.getAttribute("href");
        System.out.println("This Link is going to :" + path);

        // 03) Check broken Link

        WebElement brokenList = driver.findElement(By.linkText("Broken?"));
        brokenList.click();

        // error page title
        String title = driver.getTitle();
        if (title.contains("404")) {
            System.out.println("Link is Broken");
        } else {
            System.out.println("Link in valid");
        }
        driver.navigate().back();

        // 04) Check Duplicate Link
        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();
        // 05) Check Count page Link

        List<WebElement> countFullPageLink = driver.findElements(By.tagName("a"));
        int pageLink = countFullPageLink.size();
        System.out.println("counts of full page links ");

        // 06) Check count layout Links
        // first find correct element
        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countOfLayoutLink = layoutElement.findElements(By.tagName("a"));

    }
}