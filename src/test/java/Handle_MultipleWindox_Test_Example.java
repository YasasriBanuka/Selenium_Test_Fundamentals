import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Handle_MultipleWindox_Test_Example {


        WebDriver driver;// use for all methods

        @BeforeMethod
        public void  WindowTestPage () throws InterruptedException {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.leafground.com/window.xhtml");
            Thread.sleep(3000);
        }

        @Test
        public void windowTest() throws InterruptedException {
            // 1) Click and confirm new window opens

            String oldWindow = driver.getWindowHandle();// return string
            System.out.println("Parent Window :" + oldWindow );

            WebElement openButton = driver.findElement(By.xpath("//*[@id= 'j_idt88:new']/span"));
            openButton.click();
            Thread.sleep(3000);

            // store open new tab
            Set<String> handles = driver.getWindowHandles();
            System.out.println("Handles Size : "+ handles.size());

            // First method - using forEach loop
//        for(String newWindow :handles){
//            System.out.println(newWindow);

            //===================================================//

            // if(driver.getTitle().equals("ASD"){
            //break;
            // =================================================//
//            driver.switchTo().window(newWindow);// switch window
//            System.out.println("Page Title is : " + driver.getTitle());
//        }
//
//        driver.close();
//
//        driver.switchTo().window(oldWindow);
//

//          WebElement OpenButton = driver.findElement(By.xpath("//*[@id= 'j_idt88:new']/span"));
//          boolean openButtonVisibility = OpenButton.isDisplayed();// check web is avaliable in dom
//          System.out.println("Open Button Visibility " + openButtonVisibility);

            // Second method - using list
            List<String> list = new ArrayList<String>(handles);// converting set to the list
            if(list.size() > 1) {
                driver.switchTo().window(list.get(1));
                System.out.println("Chile tab Title is : " + driver.getTitle());
                driver.close();
                driver.switchTo().window(oldWindow);

            }
            WebElement OpenButton = driver.findElement(By.xpath("//*[@id= 'j_idt88:new']/span"));
            boolean openButtonVisibility = OpenButton.isDisplayed();// check web is avaliable in dom
            System.out.println("Open Button Visibility " + openButtonVisibility);



            // 2) find the number of opened tabs

            WebElement multiWindowButton = driver.findElement (By.xpath("//span[normalize-space()='Open Multiple']"));
            multiWindowButton.click();
            Thread.sleep(3000);

            Set<String> multiWindow =  driver.getWindowHandles();
            int howManyWindows = multiWindow.size();
            System.out.println("How many Windows open " +howManyWindows);

            // 3) close all windows expected primary

            WebElement dontCloseButton = driver.findElement(By.id("j_idt88:j_idt93"));
            dontCloseButton.click();
            Thread.sleep(3000);

            Set<String> newWindowsHandle =  driver.getWindowHandles();
            for(String allWindows :newWindowsHandle){
                if(!allWindows.equals(oldWindow)){
                    driver.switchTo().window(allWindows);
                    driver.close();

                }

            }
        }
    }

