import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBoxExample_Test {

    WebDriver driver;// use for all methods

    //check before running the test

    @BeforeMethod
    public void openLinkTestPage() throws InterruptedException{

        // ChromeOptions  chromeOptions = new ChromeOptions();
        //  chromeOptions.setBrowserVersion("122"); // fixed browser version
        //  chromeOptions.addArguments("--start-maximized");
        //  chromeOptions.addArguments("--incognito");
        //chromeOptions.addArguments("--headless");// run headlees type
        //  driver = new ChromeDriver(chromeOptions);

        driver = new ChromeDriver(); // if you want to go firefox  or edge you will enter here
        //fixed browser pc screen size
        driver.manage().window().maximize(); // manage(); manage is method chaning option
        driver.get("https://www.leafground.com/input.xhtml");
    }
    @Test
    public  void  textBoxTests(){
        // 1) Type you name
        WebElement name  = driver.findElement(By.name("j_idt88:name"));
        name.sendKeys("Yasasri Banuka");

        // 2) Append country ti this city
        WebElement appendText = driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("Colombo");

        // 3) verify if text box is disable
        boolean enabled = driver.findElement(By.name("j_idt88:j_idt93")).isEnabled(); // isEnabled use check enable or disable path
        System.out.println("Is text Box enabled" + enabled);

        // 4) Clear the type text
        //Xpath =//tagname[@attribute='value']
        // \ " = string special character
        WebElement clearText =  driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        // 5) Retrieve the typed text
        WebElement TextElement =  driver.findElement(By.id("j_idt88:j_idt97"));
        String value = TextElement.getAttribute("value");
        System.out.println(value);

        // 6) Type email and Tab , confirm control moved to next element
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("banukadias@gmail.com" + Keys.TAB + "Confirmed control moved to next element");



    }
}


