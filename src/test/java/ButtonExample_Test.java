import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample_Test {

    WebDriver driver;// use for all methods

    @BeforeMethod
    public void openButtonTestPage() {
        driver = new ChromeDriver();
//        Dimension newSize = new Dimension(800,600);
//        //fixed browser pc screen size
//        driver.manage().window().setSize(newSize);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void buttonTest(){
        // 1) click add confirm title

          driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
          String expectedTitle = "Dashboard";
          String actualTitle = driver.getTitle();

          if(expectedTitle.equals(actualTitle)){
              System.out.println("Actual Title same as expected");
          }else{
              System.out.println("Actual Title not same as expected");
          }

          // TestNG
       // Assert.assertEquals(actualTitle,expectedTitle ,"title miss matched");

        // 2) find the position of the submit button

          driver.navigate().back();
          WebElement getPosition =driver.findElement(By.id("j_idt88:j_idt94"));
          Point xyPoint = getPosition.getLocation();// return point class
            int x = xyPoint.getX();
            int y = xyPoint.getY();
        System.out.println("X position is : " + x + "Y position is : " +y);

        // 3) find the button color
          WebElement buttonColor = driver.findElement(By.id("j_idt88:j_idt96"));
          String color = buttonColor.getCssValue("background-color");
          System.out.println("Button color is : " + color);

        // 4) Find the height and wight of this button
        WebElement size = driver.findElement(By.id("j_idt88:j_idt96"));
        int height = size.getSize().getHeight();//Dimension class inside method getHeight() and getWidth().
        int width = size.getSize().getWidth();
        System.out.println("Height :" + height + "Width :" + width);


    }


}
