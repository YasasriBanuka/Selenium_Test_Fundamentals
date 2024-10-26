import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample_Test {

    WebDriver driver;// use for all methods

    @BeforeMethod
    public void openDropDownTestPage() {
        driver = new ChromeDriver();
        //fixed browser pc screen size
        driver.manage().window().maximize();

    }

    @Test
    public  void leafGroundPageDropDown() throws InterruptedException {

// Normal Drop Down

        // 1.1) Way of select values in BAsic dropdown
        // provide Select class for selenium , when start select tag elements
        driver.get("https://www.leafground.com/select.xhtml");
        WebElement dropdown =  driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        Thread.sleep(3000); // control testing time period
        select.selectByVisibleText("Playwright");
        Thread.sleep(3000);


        // 1.2) Get the number of dropdown options
        // webElement == generics
        // below list only handle webElements
        List<WebElement> listOfOptions = select.getOptions();
        int size =listOfOptions.size();
        System.out.println("Number of elements in dropDown" + size);

        //  view all options
       for(WebElement element:listOfOptions){
           System.out.println(element.getText());
        }

        // 1.3) using send_keys select dropdown value
        dropdown.sendKeys("Puppeteer");

// BOOSTRAP
        // 1.4) Selecting value in a Boostrap dropdown
        WebElement dropDownElement = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropDownElement.click();
        List<WebElement> ListOfDropDownValues = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));

        //
        for(WebElement element :ListOfDropDownValues){
            String droDownValue = element.getText();
            if(droDownValue.equals("USA")){
                element.click();
                break;
            }
        }
    }

// 2) Google Search - pick a value from suggestions

    @Test
    public void googleSearchdropDown() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("cardiff");
        Thread.sleep(2000);
        List<WebElement>  googleSearchList = driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d WggQGd']"));
        System.out.println(googleSearchList.size());

        for(WebElement webElement :googleSearchList){
            System.out.println(webElement.getText());
          if(webElement.equals("Cardiff Metropolitan University")){
              webElement.click();
              break;
          }
        }
    }

// 3) handle hidden Auto Suggestions Drop Down and Search Using DOM Debugger Trick
















}
